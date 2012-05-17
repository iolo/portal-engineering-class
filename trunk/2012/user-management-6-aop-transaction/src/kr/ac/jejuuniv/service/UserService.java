package kr.ac.jejuuniv.service;

import java.util.List;

import kr.ac.jejuuniv.mapper.UserMapper;
import kr.ac.jejuuniv.model.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
	
	@Autowired
	private UserMapper userMapper;
	
	public UserService() {
	}
	
	public List<User> getList() {
		List<User> users = userMapper.findAll();
		return users;
	}
	
	public List<User> getListOrderByIdDesc() {
		List<User> users = userMapper.findAllOrderByIdDesc();
		return users;
	}

	public void addUser(User user) {
		userMapper.addUser(user);
	}

	public void deleteAndAddUser(String deleteUserId, User user, boolean throwException) {
			
		userMapper.deleteUser(deleteUserId);
		if (throwException) {
			throw new RuntimeException("Unknown error.");
		}
		userMapper.addUser(user);

	}

}
