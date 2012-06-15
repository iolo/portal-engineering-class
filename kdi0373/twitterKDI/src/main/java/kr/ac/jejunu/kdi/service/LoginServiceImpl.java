package kr.ac.jejunu.kdi.service;

import kr.ac.jejunu.kdi.model.User;
import kr.ac.jejunu.kdi.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class LoginServiceImpl implements LoginService{
	String userId;
    String userPassword;
	
	@Autowired
	UserRepository userRepository;
	
	User user;

	@Override
	public boolean login(String id, String password) {
		 
		
		user = userRepository.loginCheck(id,password);
		
		
		 
		if( user != null ){
		
			return true;
		}
		else{
			
			return false;
		}
		
		
	}

	
	
}
