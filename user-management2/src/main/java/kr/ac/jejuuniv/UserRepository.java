package kr.ac.jejuuniv;

import java.util.List;

public interface UserRepository {

	List<User> findAll();

	void deleteById(String id);

	void insert(User user);

	User findUser(String id);

	User findById(String id);

	void update(User user);

}
