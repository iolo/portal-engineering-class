package kr.ac.jejuuniv.test;

import java.util.List;

public interface UserRepository {
	void insert(User user);
	
	void update(User user);
	
	void delete(String id);
	
	User findById(String id);
	
	List<User> findAll();

	List<User> List();

}
