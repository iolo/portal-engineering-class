package kr.ac.jejunu.rabbit.service;

import kr.ac.jejunu.rabbit.model.User;

public interface UserService {
	
	void insert(User user);
	
	void delete(String id);
	
	User get(String id);
	
	<List>User List();
}
