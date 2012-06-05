package kr.ac.jejuuniv.service.impl;

import kr.ac.jejuuniv.model.User;
import kr.ac.jejuuniv.repository.UserRepository;
import kr.ac.jejuuniv.service.UserService;

public class UserServiceImpl implements UserService {

	UserRepository userRepository;
	
	public UserServiceImpl(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	public User getUser(String userId) {
		return userRepository.findUserByUserId(userId);
	}

}
