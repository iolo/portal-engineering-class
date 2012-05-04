package kr.ac.jejuuniv;

import java.util.List;

public interface UserRepository {

	List<User> findAll();
	User findById(String id);
	void insert(User user);
	void delete(String id);
	void update(User user);

	

}
