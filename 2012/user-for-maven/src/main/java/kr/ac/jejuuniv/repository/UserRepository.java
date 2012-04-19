package kr.ac.jejuuniv.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import kr.ac.jejuuniv.model.User;

@Repository
public interface UserRepository {

	List<User> findAll();

	User findById(String id);

	void insert(User user);

	void update(User user);

	void delete(String id);

}
