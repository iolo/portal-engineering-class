package kr.ac.jejuuniv.service.social;

import java.util.List;

import kr.ac.jejuuniv.model.User;

public interface SocialNetworkService {
	
	List<User> getFollows(String userId);
	
	List<User> getFollowers(String userId);
	
	void follow(String followId);
	
	void unFollow(String unFollowId);
	
}
