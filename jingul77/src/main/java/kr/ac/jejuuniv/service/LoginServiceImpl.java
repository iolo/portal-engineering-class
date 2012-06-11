package kr.ac.jejuuniv.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import kr.ac.jejuuniv.mapper.LoginMapper;
import kr.ac.jejuuniv.model.UserModel;

@Service
public class LoginServiceImpl implements LoginService {

	UserModel user;

	@Autowired
	LoginMapper loginMapper;

	@Override
	public boolean loginCheck(String id, String password, Model model) {

		Map<String, String> LoginMap = new HashMap<String, String>();
		LoginMap.put("id", id);
		LoginMap.put("password", password);
		user = loginMapper.findById(LoginMap);
		
		if (user != null) {
			model.addAttribute("user", user);			
			return true;
			}
			else 
			return false;
	}

	@Override
	public UserModel findById(String id) {

		return user;
	}
}
