package kr.ac.jejuuniv.Service;

import kr.ac.jejuuniv.Model.User;
import kr.ac.jejuuniv.Repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;

public class LoginServiceImpl implements LoginService{

	@Autowired
	private UserRepository userRepository;

	public LoginServiceImpl() {
	}
	
	public LoginServiceImpl(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	public User checkUser(String id, String password) {
		return userRepository.checkUser(id, password); 
	}
}
