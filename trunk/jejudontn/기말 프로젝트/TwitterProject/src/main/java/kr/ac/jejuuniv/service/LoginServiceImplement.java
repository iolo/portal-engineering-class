package kr.ac.jejuuniv.service;

import java.util.HashMap;
import java.util.Map;

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

		Map<String, String> LoginMap = new HashMap<String, String>();
		LoginMap.put("id", id);
		LoginMap.put("password", password);

		user = loginmapper.findUserById(LoginMap);
		if (user == null) {
			return false;
		} else {
			return true;
		}
	}

	@Override
	public User findUserById(String id) {
		return user;
	}

}
