package com.jejuuniv;

import java.util.List;

public class UserServiceImplement implements UserService {
	private UserRepository userRepository;

	public UserServiceImplement(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	public List<User> list() {
		
		return  userRepository.findAll();
	}

	public User getUserList(String id) {
		return userRepository.findUser(id);
	}

	public User addUser(User user) {
		// TODO Auto-generated method stub
		return userRepository.addUser(user);
	}

	public User deleteUserList(String id) {
		// TODO Auto-generated method stub
		return userRepository.deleteUser(id);
	}

}
