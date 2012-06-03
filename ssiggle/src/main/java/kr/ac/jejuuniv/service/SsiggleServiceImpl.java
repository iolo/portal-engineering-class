package kr.ac.jejuuniv.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import kr.ac.jejuuniv.model.ssiggle.Ssiggle;
import kr.ac.jejuuniv.model.user.User;

import org.springframework.stereotype.Service;

@Service
public class SsiggleServiceImpl implements SsiggleService {
	@Override
	public List<Ssiggle> readAllSsiggleByFollowingUser(User user,
			Ssiggle ssiggle) {
		List<User> followingList = user.followingUserList();

		List<Ssiggle> item = new ArrayList<>(
				ssiggle.ssiggleListByUserIdDesTime(user.getId()));
		for (User u : followingList) {
			item.addAll(ssiggle.ssiggleListByUserIdDesTime(u.getId()));
		}
		System.out.println(item.size());

		Collections.sort(item, new Comparator<Ssiggle>() {
			@Override
			public int compare(Ssiggle o1, Ssiggle o2) {
				return o1.getTime().compareTo(o2.getTime());
			}
		});

		Collections.reverse(item);
		return item;
	}
}
