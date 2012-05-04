package kr.ac.jejunu.kdi.service;

import java.util.List;

import kr.ac.jejunu.kdi.model.User;

public interface UserService {

	List<User> list();

	void userCreate(String id, String name, String password);


	void deleteUserList(String id);


	
}
