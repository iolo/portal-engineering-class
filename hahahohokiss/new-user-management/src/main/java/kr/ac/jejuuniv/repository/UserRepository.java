package kr.ac.jejuuniv.repository;

import java.util.List;

import kr.ac.jejuuniv.model.User;

public interface UserRepository {

	List<User> findAll();

	User findById(String id);

	User insert(User user);

	User update(User user);

	void delete(String id);

}
