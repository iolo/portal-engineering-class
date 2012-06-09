package jnu.ce.bs.k.service;

import java.util.List;
import java.util.Map;

import jnu.ce.bs.k.model.Note;
import jnu.ce.bs.k.model.User;
import jnu.ce.bs.k.persistence.UserMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

	@Override
	public User login(Map<String, String> map) {

		return userMapper.login(map);
	}

	@Override
	public List<Note> findAllNoteByID(String id) {
		
		return userMapper.findAllNoteById(id);
	}

}
