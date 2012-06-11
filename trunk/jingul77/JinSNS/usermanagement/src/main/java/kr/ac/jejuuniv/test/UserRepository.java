package kr.ac.jejuuniv.test;

import java.util.List;

public interface UserRepository {
	void insert(User user);
	
	void update(String id, String name, String password);
	
	void delete(String id);
	
	void addUser(String id, String name, String password);
	
	User findById(String id);
	
	List<User> findAll();

	List<User> List();

}
