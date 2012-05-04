package kr.ac.jejunu.rabbit.repository;

import java.util.List;

import kr.ac.jejunu.rabbit.model.User;
public interface UserRepository {

	void update(User user);	
	
	void delete(String id);
	
	User findById(String id);
	
	List<User> findAll();

	void insert(String id, String name, String password);

	void modifyUser(String id, String name, String password);
	
}
