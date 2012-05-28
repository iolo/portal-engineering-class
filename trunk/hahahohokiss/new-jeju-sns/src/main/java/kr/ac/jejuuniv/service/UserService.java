package kr.ac.jejuuniv.service;

import kr.ac.jejuuniv.model.User;

public interface UserService {

	User getUserByUserId(String id);

	String getPasswordByUserId(String id);

	User add(User user);

}
