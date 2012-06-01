package kr.ac.jejuuniv.Service;

import kr.ac.jejuuniv.Model.User;

public interface UserService {

	User checkUser(String id, String password);

	User getUser(int userNum);

	void addUser(User user);

	void update(User user);

}
