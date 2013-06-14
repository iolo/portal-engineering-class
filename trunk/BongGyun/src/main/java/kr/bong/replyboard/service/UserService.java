package kr.bong.replyboard.service;

import kr.bong.replyboard.model.User;

public interface UserService {
	int join(User user);
	
	int modify(User user);
	
	User getUser(String id);
	
	boolean loginCheck(String id, String password);
}
