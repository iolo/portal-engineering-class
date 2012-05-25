package kr.ac.jejuuniv.service;

import org.springframework.stereotype.Service;

@Service
public class LoginServiceImplement implements LoginService {

	@Override
	public boolean checkIdAndPassword(String id, String password) {
		return true;
	}


}
