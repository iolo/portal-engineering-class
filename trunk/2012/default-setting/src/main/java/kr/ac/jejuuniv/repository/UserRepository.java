package kr.ac.jejuuniv.repository;

import java.util.List;

import kr.ac.jejuuniv.model.User;

public interface UserRepository {
	List<User> findAll();
	List<User> findById(String id);
	
	void insert(User user);
	void update(User user);
	void remove(String id);
}
