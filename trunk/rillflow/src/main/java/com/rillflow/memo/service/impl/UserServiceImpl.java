package com.rillflow.memo.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rillflow.memo.model.User;
import com.rillflow.memo.repository.UserDao;
import com.rillflow.memo.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	UserDao userDao;
	
	@Override
	public int join(User user) {
		return userDao.insertUser(user);
	}

	@Override
	public int modify(User user) {
		return userDao.updateUser(user);
	}

	@Override
	public int remove(String id) {
		return userDao.deleteUser(id);
	}
	
	@Override
	public User getUser(String id) {
		return userDao.selectUser(id);
	}

	@Override
	public User login(String id, String password) {
		User user = getUser(id);
		
		if(user != null && user.getPassword().equals(password))
			return user;
		else
			return null;
	}
}
