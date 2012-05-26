package kr.ac.jejuuniv.service;

import kr.ac.jejuuniv.model.LoginModel;
import kr.ac.jejuuniv.model.User;
import kr.ac.jejuuniv.repository.LoginMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginServiceImplement implements LoginService {
	User user;

	@Autowired
	LoginMapper loginmapper;

	@Override
	public boolean checkIdAndPassword(String id, String password) {
		
		LoginModel loginModel = new LoginModel(id,password);
		user = loginmapper.findUserById(loginModel);

		return true;
	}

	@Override
	public User findUserById(String id) {
		return user;
	}

}
