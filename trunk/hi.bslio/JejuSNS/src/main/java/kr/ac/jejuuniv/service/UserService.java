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
	
	public List<UserModel> getList(String notlikeId) {
		List<UserModel> users = userMapper.findAll(notlikeId);
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
	
	public List<UserModel> getFollowingList(String id) {
		return userMapper.findFollowing(id);
	}
	
	public List<UserModel> getFollowerList(String id) {
		return userMapper.findFollower(id);
	}
}
