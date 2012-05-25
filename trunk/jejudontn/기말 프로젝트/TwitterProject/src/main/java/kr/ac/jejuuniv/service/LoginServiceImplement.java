package kr.ac.jejuuniv.service;

import kr.ac.jejuuniv.model.User;
import kr.ac.jejuuniv.repository.LoginMapper;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginServiceImplement implements LoginService {
	static User user;
	
	LoginMapper loginMapper;
	
	

	@Override
	public boolean checkIdAndPassword(String id, String password) {
		
		user = loginMapper.findUserById(new User());
		
		
		return true;
	}

	@Override
	public User findUserById(String id) {
		return user;
	}

	

	


}
