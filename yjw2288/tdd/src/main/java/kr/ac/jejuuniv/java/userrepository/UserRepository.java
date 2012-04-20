package kr.ac.jejuuniv.java.userrepository;

import java.util.List;

import kr.ac.jejuuniv.java.User;

public interface UserRepository {
	User findUserById(String id);

	void insertUser(User user);

	void deleteUserById(String id);

	void updateUser(User user);

	List<User> findAllUser();
}