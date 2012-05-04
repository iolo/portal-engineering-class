package kr.ac.jejunu.kdi.service;


import java.util.List;

import kr.ac.jejunu.kdi.model.User;
import kr.ac.jejunu.kdi.repository.UserRepository;

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

	
	@Override
	public List<User> list() {
		
		return  userRepository.findAll();
	}

	@Override
	public void userCreate(String id, String name, String password){
		 userRepository.createUser(id, name, password);
	}


	
	public void deleteUserList(String id) {
		userRepository.deleteUser(id);

	}

}
