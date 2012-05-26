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

	public Boolean checkUser(String id, String password) {
		User user = userRepository.checkUser(id, password); 
		if(user.getPassword().equals(password)){
			return true;
		}
		return false;
	}
}
