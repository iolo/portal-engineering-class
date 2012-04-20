package com.jejuuniv;

import java.util.List;


public interface UserRepository {

	List<User> findAll();


	User findUser(String id);


	User addUser(User user);


	User deleteUser(String string);

}
