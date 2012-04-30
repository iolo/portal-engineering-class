package kr.ac.jejuuniv;

import java.util.List;

public interface UserRepository {

	List<User> findAll();

	void deleteById(String id);

	void insert(User user);

}
