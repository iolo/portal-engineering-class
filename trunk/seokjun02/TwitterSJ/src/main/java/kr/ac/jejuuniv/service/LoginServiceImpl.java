package kr.ac.jejuuniv.service;

import kr.ac.jejuuniv.mapper.UserMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginServiceImpl implements LoginService {

	@Autowired
	private UserMapper userMapper;
	private int check = 0;

	@Override
	public void memberLogin(String id, String password) {

	}

	@Override
	public boolean checkUser(String id, String password) {
		System.out.println(userMapper.checkUser(id, password));
		System.out.println(id + " : " + password);
		return (userMapper.checkUser(id, password) == 1)? true:false;
//		User user = userMapper.checkUser(id);
//		if(user != null && user.getPassword().equals(password)){
//			return true;
//		}
//		return false;
	}
}
