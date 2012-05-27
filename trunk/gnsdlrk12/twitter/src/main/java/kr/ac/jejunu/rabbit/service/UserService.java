package kr.ac.jejunu.rabbit.service;

import kr.ac.jejunu.rabbit.model.User;

public interface UserService {
	
	void insert(User user);
	
	void delete(String userid);
	
	User get(String userid);
	
	<List>User List();
}
