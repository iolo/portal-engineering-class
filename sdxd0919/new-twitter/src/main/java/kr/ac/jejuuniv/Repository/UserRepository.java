package kr.ac.jejuuniv.Repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import kr.ac.jejuuniv.Model.User;

@Repository
public interface UserRepository {
	
	User getUserByUserNum(int userNum);

	User getUserById(String id);

	void insert(User user);

	void update(User user);

	List<User> getAllUser();

	int getUserNumById(String id);

	String getPassword(String id);

}
