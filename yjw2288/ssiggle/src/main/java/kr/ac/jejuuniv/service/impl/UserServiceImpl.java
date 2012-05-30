package kr.ac.jejuuniv.service.impl;

import java.util.List;

import kr.ac.jejuuniv.mapper.UserMapper;
import kr.ac.jejuuniv.model.User;
import kr.ac.jejuuniv.service.UserService;
import kr.ac.jejuuniv.service.user.FollowingUserNotFoundException;
import kr.ac.jejuuniv.service.user.NotFollowingUserException;
import kr.ac.jejuuniv.service.user.NotFoundUserException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserMapper userMapper;

	@Override
	public void setMapper(UserMapper repository) {
		this.userMapper = repository;
	}

	@Override
	public User findUserById(String id) {
		User user = userMapper.selectUserById(id);
		if (user == null) {
			throw new NotFoundUserException("id : id 인 User(을)를 찾지 못했습니다.");
		}
		return user;
	}

	@Override
	public void saveUser(User user) {
		if (userMapper.selectUserById(user.getId()) == null) {
			userMapper.insertUser(user);
		} else {
			userMapper.updateUser(user);
		}
	}

	@Override
	public void followingUser(User user, User targetUser) {
		if (userMapper.selectUserById(user.getId()) == null
				|| userMapper.selectUserById(targetUser.getId()) == null) {
			throw new FollowingUserNotFoundException("원하는 User(이)가 존재하지 않습니다.");
		}

		user.getFollowingUser().add(targetUser);
		userMapper.updateUser(user);
	}

	@Override
	public void unFollowingUser(User user, User targetUser) {
		if (userMapper.selectUserById(user.getId()) == null
				|| userMapper.selectUserById(targetUser.getId()) == null) {
			throw new UnFollowingUserNotFoundException(
					"원하는 User(이)가 존재하지 않습니다.");
		}

		if (!user.getFollowingUser().contains(targetUser)) {
			throw new NotFollowingUserException("User " + user.getId()
					+ " (은)는 User " + targetUser.getId()
					+ " (을)를 팔로잉 하고 있지 않습니다.");
		}

		user.getFollowingUser().remove(targetUser);
		userMapper.updateUser(user);
	}

	@Override
	public List<User> userList() {
		return userMapper.selectAllUser();
	}
}