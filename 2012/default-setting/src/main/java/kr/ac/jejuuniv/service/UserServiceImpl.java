package kr.ac.jejuuniv.service;

import java.util.List;

import kr.ac.jejuuniv.model.User;
import kr.ac.jejuuniv.repository.UserRepository;

public class UserServiceImpl implements UserService {

	private UserRepository userRepository;
	
	public List<User> findAll() {
		return userRepository.findAll();		
	}

}
