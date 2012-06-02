package kr.ac.jejuuniv.Repository;

import java.util.List;

import kr.ac.jejuuniv.Model.User;

public interface UserRepository {
	
	User findByUserNum(int userNum);

	User getUserById(String id);

	void insert(User user);

	void update(User user);

	List<User> getAll();

}
