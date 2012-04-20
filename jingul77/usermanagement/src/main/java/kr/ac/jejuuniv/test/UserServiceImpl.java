package kr.ac.jejuuniv.test;


import java.util.ArrayList;
import java.util.DuplicateFormatFlagsException;
import java.util.List;

import org.mockito.Mock;

public class UserServiceImpl implements UserService {

	private static List<User> users = new ArrayList<User>();
	
	
	private UserRepository repository;
	
	public List<User> listUser() {
		List<User> foundusers = repository.findAll();
		return foundusers;
	}

	public void setUserRepository(UserRepository repository) {
		this.repository = repository;
	}

	@Override
	public User get(String id) {
		User user = repository.findById(id);
		return user;
	}

	@Override
	public void removeById(String Id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void addUser(User user) {
		User foundUser=repository.findById(user.getId());
		
	}

	@Override
	public void modifyUser(User user) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<User> findAll() {
		List<User> foundusers = repository.findAll();
		return foundusers;
	}

}
