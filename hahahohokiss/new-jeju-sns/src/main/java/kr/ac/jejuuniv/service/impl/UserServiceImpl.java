package kr.ac.jejuuniv.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
	
	public void setUserRepository(UserRepository userRepository) {
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

	public User add(User user) {
		return	userRepository.insert(user);
	}


	public List<User> getAllUser() {
		return userRepository.findAllUser();
	}
}
