package kr.ac.jejuuniv.Service;

import java.util.List;

import kr.ac.jejuuniv.Model.User;

public interface UserService {

	User checkUser(String id, String password);

	User getUser(int userNum);

	void addUser(User user);

	void update(User user);

	List<User> getAllUser();

	User getUserById(String id);

	int getUserNum(String id);

}
