package kr.ac.jejuuniv.service;

import java.util.List;

import kr.ac.jejuuniv.mapper.SsiggleMapper;
import kr.ac.jejuuniv.mapper.UserMapper;
import kr.ac.jejuuniv.model.Ssiggle;

public interface SsiggleService {
	void setSsiggleMapper(SsiggleMapper ssiggleRepository);

	void setUserMapper(UserMapper userRepository);
	
	void removeSsiggleById(long id);

	void saveSsiggle(Ssiggle s);

	Ssiggle getSsiggleBy(long id);

	List<Ssiggle> ssiggleListFollowingAndUserByUserIdDescTime(String userId);

	List<Ssiggle> ssiggleListByUserIdDesTime(String userId);
}
