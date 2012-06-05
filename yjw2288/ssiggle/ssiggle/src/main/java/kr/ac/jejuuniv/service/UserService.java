package kr.ac.jejuuniv.service;

import java.util.List;

import kr.ac.jejuuniv.mapper.UserMapper;
import kr.ac.jejuuniv.model.User;

public interface UserService {

	void setMapper(UserMapper userMapper);

	User findUserById(String id);

	void saveUser(User user);

	void followingUser(User user, User targetUser);

	void unFollowingUser(User user, User targetUser);

	List<User> userList();
}
