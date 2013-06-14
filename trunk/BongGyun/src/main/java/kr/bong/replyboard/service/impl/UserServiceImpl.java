package kr.bong.replyboard.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.bong.replyboard.model.User;
import kr.bong.replyboard.repository.UserDao;
import kr.bong.replyboard.service.UserService;

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
	public User getUser(String id) {
		return userDao.selectUser(id);
	}

	@Override
	public boolean loginCheck(String id, String password) {
		User user = userDao.selectUser(id);
		
		if(user == null)
			return false;
		
		return user.getPassword().equals(password);
	}

	
}
