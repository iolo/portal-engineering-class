package kr.ac.hyosang.service;

import kr.ac.hyosang.model.User;
 
public interface UserService {
	int userJoin(User user);

	User loginCheck(String UserId, String password);

	int modify(User user);
}
