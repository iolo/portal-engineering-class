package kr.ac.jejuuniv.Repository;

import java.util.List;

import kr.ac.jejununiv.model.User;


public interface UserRepository {

	List<User> findAll();


	boolean createUser(String id, String name, String password);


	void deleteUser(String string);


	User findById(String id);


	void modifyUser(String id, String name, String password);

}
