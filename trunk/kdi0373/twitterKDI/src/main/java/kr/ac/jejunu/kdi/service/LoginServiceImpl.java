package kr.ac.jejunu.kdi.service;

import kr.ac.jejunu.kdi.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class LoginServiceImpl implements LoginService{


	
	@Autowired
	UserRepository userRepository;
	
	@Override
	public boolean login(String id, String password) {
		if(userRepository.loginCheck(id, password) != null){
			
			//loginUser
			return true;
		}
		else{
			return false;
		}
	}

	
	
}
