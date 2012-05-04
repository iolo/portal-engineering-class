package kr.ac.jejuuniv.Service;

import java.util.List;

import kr.ac.jejununiv.model.User;

public interface UserService {

	List<User> list();


	void deleteUserList(String string);


	boolean userCreate(String id, String name, String password);


	User findById(String id);


	void userModify(String id, String name, String password);

}
