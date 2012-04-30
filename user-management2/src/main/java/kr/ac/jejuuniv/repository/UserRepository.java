package kr.ac.jejuuniv.repository;

import java.util.List;

import kr.ac.jejuuniv.model.User;

public interface UserRepository {

	List<User> findAll();

	void delete(String id);

	void insert(User user);

	User findById(String id);

	void update(User user);

}
