package kr.ac.jejuuniv.Service;

import kr.ac.jejuuniv.Model.User;
import kr.ac.jejuuniv.Repository.UserRepository;

public class LoginServiceImpl implements LoginService {
	
	UserRepository userRepository;
	
	public LoginServiceImpl() {
	}
	
	public LoginServiceImpl(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	public User checkUser(String id, String password) {
		return userRepository.getUserById(id);
	}

}
