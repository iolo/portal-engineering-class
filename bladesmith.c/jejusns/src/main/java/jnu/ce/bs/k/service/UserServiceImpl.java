package jnu.ce.bs.k.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jnu.ce.bs.k.model.User;
import jnu.ce.bs.k.persistence.UserMapper;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserMapper userMapper;

	@Override
	public void createUser(String id, String password, String name,
			String description, String profile) {

		User user = new User(id, password, name, description, profile);
		userMapper.addUser(user);
	}

}
