package kr.ac.jejuuniv;

import java.util.List;

public interface UserService {

	List<User> list();


	void deleteUserList(String string);


	void userCreate(String id, String name, String password);


	User findById(String id);


	void userModify(String id, String name, String password);

}
