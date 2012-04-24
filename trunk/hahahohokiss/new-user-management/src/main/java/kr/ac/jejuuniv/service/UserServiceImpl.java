package kr.ac.jejuuniv.service;

import java.util.List;

import kr.ac.jejuuniv.exception.DataNotFoundException;
import kr.ac.jejuuniv.model.User;
import kr.ac.jejuuniv.repository.UserRepository;

public class UserServiceImpl implements UserService {

	UserRepository userRepository;
	
	public UserServiceImpl(UserRepository userRepository) {
		this.userRepository = userRepository;
	}
	
	public List<User> list() {
		return userRepository.findAll();
	}

	public User get(String id) {
		if(userRepository.findById(id) == null){
			throw new DataNotFoundException();
		}
		else
			return userRepository.findById(id);
	}

	public User add(User user) {
		return userRepository.insert(user);
	}

	public User modify(User user) {
		return userRepository.update(user);
	}

	public void delete(String id) {
		userRepository.delete(id);
	}

}
