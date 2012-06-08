package kr.ac.jejuuniv.service;

import kr.ac.jejuuniv.mapper.UserMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginServiceImpl implements LoginService {

	@Autowired
	private UserMapper userMapper;

	@Override
	public void memberLogin(String id, String password) {

	}

	@Override
	public boolean checkUser(String id, String password) {
		return (userMapper.checkUser(id, password) == 1)? true:false;
	}
}
