package kr.ac.jejuuniv.Service;


import java.util.List;

import kr.ac.jejununiv.model.User;
import kr.ac.jejuuniv.Repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImplement implements UserService {
	@Autowired
	private UserRepository userRepository;

	public UserServiceImplement(UserRepository userRepository) {
		this.userRepository = userRepository;
	}
	
	public UserServiceImplement() {
		
	}

	public List<User> list() {
		
		return  userRepository.findAll();
	}


	public void deleteUserList(String id) {
		userRepository.deleteUser(id);
	}

	@Override
	public boolean userCreate(String id, String name, String password) {
		return userRepository.createUser(id, name, password);
	}

	@Override
	public User findById(String id) {
		return userRepository.findById(id);
		
	}

	@Override
	public void userModify(String id, String name, String password) {
		userRepository.modifyUser(id, name, password);
		
	}

	



}
