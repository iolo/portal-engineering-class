package kr.ac.jejuuniv.repository;

import java.util.List;

import kr.ac.jejuuniv.model.User;

public interface UserRepository {
	User findUserById(String id);

	void insertUser(User user);

	void deleteUserById(String id);

	void updateUser(User user);

	List<User> findAllUser();
}