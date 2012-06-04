package kr.ac.jejuuniv.service;

import java.util.List;

import kr.ac.jejuuniv.model.User;
import kr.ac.jejuuniv.repository.UserRepository;

public interface UserService {
	
	void setUserRepository(UserRepository userRepository);
	
	User getUserByUserId(String id);

	String getPasswordByUserId(String id);

	User add(User user);



	List<User> getAllUser();


}
