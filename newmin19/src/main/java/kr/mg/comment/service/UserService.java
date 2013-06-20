package kr.mg.comment.service;

import kr.mg.comment.model.User;

public interface UserService {

	int join(User user);

	int modify(User user);

	int getData(User user);

	User login(User user);
}
