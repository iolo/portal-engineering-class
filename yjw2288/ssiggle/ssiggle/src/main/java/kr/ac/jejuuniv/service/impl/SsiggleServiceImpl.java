package kr.ac.jejuuniv.service.impl;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.ac.jejuuniv.mapper.SsiggleMapper;
import kr.ac.jejuuniv.mapper.UserMapper;
import kr.ac.jejuuniv.model.NotFoundUserException;
import kr.ac.jejuuniv.model.User;
import kr.ac.jejuuniv.model.Ssiggle;
import kr.ac.jejuuniv.service.SsiggleService;
import kr.ac.jejuuniv.service.ssiggle.NotExistSsiggleException;
import kr.ac.jejuuniv.service.ssiggle.NotRemoveSsiggleException;

@Service
public class SsiggleServiceImpl implements SsiggleService {
	@Autowired
	private SsiggleMapper ssiggleMapper;
	@Autowired
	private UserMapper userMapper;

	@Override
	public void setSsiggleMapper(SsiggleMapper repository) {
		this.ssiggleMapper = repository;
	}

	@Override
	public void setUserMapper(UserMapper userRepository) {
		this.userMapper = userRepository;
	}

	@Override
	public Ssiggle getSsiggleBy(long id) {
		Ssiggle s = ssiggleMapper.selectSsiggleById(id);

		if (s == null) {
			throw new NotExistSsiggleException("ID 값이 " + id
					+ " 인 Ssiggle이 없습니다.");
		}
		return s;
	}

	@Override
	public void removeSsiggleById(long id) {
		Ssiggle s = ssiggleMapper.selectSsiggleById(id);
		if (s == null) {
			throw new NotRemoveSsiggleException("ID 값이 " + id
					+ " 인 Ssiggle이 없습니다.");
		}

		ssiggleMapper.deleteSsiggleById(id);
	}

	@Override
	public void saveSsiggle(Ssiggle s) {
		Ssiggle item = ssiggleMapper.selectSsiggleById(s.getId());
		if (item == null) {
			ssiggleMapper.insertSsiggle(s);
		} else {
			ssiggleMapper.updateSsiggle(s);
		}
	}

	// TODO : 등록되지 않은 UserId가 입력이 된 경우 Exception을 발생시키도록 한다.
	@Override
	public List<Ssiggle> ssiggleListByUserIdDesTime(String userId) {
		User user = userMapper.selectUserById(userId);
		if (user == null) {
			throw new NotFoundUserException("id : id 인 User(을)를 찾지 못했습니다.");
		}

		return ssiggleMapper.selectSsiggleListByUserIdDescTime(userId);
	}

	// TODO : 서비스에서 전달받는 인자를 User 로하면 좋을지 id 값을 가지고 있는 String 으로 하면 좋을지....
	@Override
	public List<Ssiggle> ssiggleListFollowingAndUserByUserIdDescTime(
			String userId) {
		List<Ssiggle> ssiggleList = ssiggleMapper
				.selectSsiggleListByUserIdDescTime(userId);

		User user = userMapper.selectUserById(userId);
		for (User u : user.getFollowingUser()) {
			ssiggleList.addAll(ssiggleMapper
					.selectSsiggleListByUserIdDescTime(u.getId()));
		}

		Collections.sort(ssiggleList, new Comparator<Ssiggle>() {
			@Override
			public int compare(Ssiggle o1, Ssiggle o2) {
				return o1.getTime().compareTo(o2.getTime());
			}
		});

		return ssiggleList;
	}
}