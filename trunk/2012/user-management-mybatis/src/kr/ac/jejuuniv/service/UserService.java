package kr.ac.jejuuniv.service;

import java.util.List;

import kr.ac.jejuuniv.model.User;
import kr.ac.jejuuniv.repository.IUserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
	
	@Autowired
	private IUserRepository userRepository;
	
	public UserService() {
	}
	
	public List<User> getList() {
		List<User> users = userRepository.findAll();
		return users;
	}
	
	public List<User> getListOrderByIdDesc() {
		List<User> users = userRepository.findAllOrderByIdDesc();
		return users;
	}

}
