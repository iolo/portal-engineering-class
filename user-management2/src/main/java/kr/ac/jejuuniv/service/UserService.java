package kr.ac.jejuuniv.service;

import java.util.List;

import kr.ac.jejuuniv.model.User;

public interface UserService {

	List<User> list();

	void remove(String id);

	void save(User user);

	User getUser(String id);
	
}
