package kr.ac.jejuuniv.service.impl;

import kr.ac.jejuuniv.exception.UserNotFoundException;
import kr.ac.jejuuniv.model.User;
import kr.ac.jejuuniv.repository.UserRepository;
import kr.ac.jejuuniv.service.UserService;

public class UserServiceImpl implements UserService {

	UserRepository userRepository;
	
	public UserServiceImpl() {
		
	}
	
	public UserServiceImpl(UserRepository userRepository) {
		this.userRepository = userRepository;
	}
	
	public User getUserByUserId(String id) {
		if(userRepository.findUserByUserId(id) != null) {
			return userRepository.findUserByUserId(id);
		}
		throw new UserNotFoundException();
	}

	public String getPasswordByUserId(String id) {
		return userRepository.findPasswordByUserId(id);
	}

}
