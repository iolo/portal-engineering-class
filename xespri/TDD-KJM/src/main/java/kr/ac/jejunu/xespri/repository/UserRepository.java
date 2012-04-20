package kr.ac.jejunu.xespri.repository;

import java.util.List;

import kr.ac.jejunu.xespri.model.User;


public interface UserRepository {
	List<User> findAll();
	
	User findById(String id);
	
	void insert(User user);

	void update(User user);

	void delete(String id);

	
}