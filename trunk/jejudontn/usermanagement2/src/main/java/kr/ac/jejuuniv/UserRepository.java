package kr.ac.jejuuniv;

import java.util.List;


public interface UserRepository {

	List<User> findAll();


	void createUser(String id, String name, String password);


	void deleteUser(String string);


	User findById(String id);


	void modifyUser(String id, String name, String password);

}
