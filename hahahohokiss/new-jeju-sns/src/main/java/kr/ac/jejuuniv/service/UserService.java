package kr.ac.jejuuniv.service;

import java.util.List;

import kr.ac.jejuuniv.model.User;
import kr.ac.jejuuniv.repository.FollowRepository;
import kr.ac.jejuuniv.repository.UserRepository;

public interface UserService {
	
	void setUserRepository(UserRepository userRepository);
	
	void setFollowRepository(FollowRepository followRepository);
	
	User getUserByUserId(String id);

	String getPasswordByUserId(String id);

	User add(User user);

	String registerFollowing(String followerId, String followingId);

	List<User> getFollower(String id);

	List<String> getFollowersId(String id);

}
