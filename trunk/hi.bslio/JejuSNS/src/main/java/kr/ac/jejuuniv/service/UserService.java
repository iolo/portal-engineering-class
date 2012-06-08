package kr.ac.jejuuniv.service;

import java.util.List;

import kr.ac.jejuuniv.mapper.UserMapper;
import kr.ac.jejuuniv.model.UserModel;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
	
	@Autowired
	private UserMapper userMapper;
	
	public List<UserModel> getList() {
		List<UserModel> users = userMapper.findAll();
		return users;
	}

	public void insertUser(UserModel user) {
		userMapper.insertUser(user);
	}

	public UserModel getUser(String id) {
		UserModel user = userMapper.findById(id);
		return user;
	}
	
	public void updateUser(UserModel user) {
		userMapper.updateUser(user);
	}
}
