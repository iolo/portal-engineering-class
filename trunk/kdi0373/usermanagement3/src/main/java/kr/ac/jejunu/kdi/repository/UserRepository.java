package kr.ac.jejunu.kdi.repository;

import java.util.List;

import kr.ac.jejunu.kdi.model.User;

public interface UserRepository {

	List<User> findAll();

	void createUser(String id, String name, String password);


	void deleteUser(String id);

}
