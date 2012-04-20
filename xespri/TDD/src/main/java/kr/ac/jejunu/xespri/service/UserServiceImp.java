package kr.ac.jejunu.xespri.service;

import java.util.List;

import kr.ac.jejunu.xespri.model.User;
import kr.ac.jejunu.xespri.repository.UserRepository;

public class UserServiceImp implements UserService {
	private UserRepository repository;
	public User get(String id) {
		User user = repository.findById(id);
		return user;
	}

	public void removeById(String id) {
		// TODO Auto-generated method stub
		
	}

	public void addUser(User user) {
		User foundUser = repository.findById(user.getId());
		
	}

	public void modifyUser(User user) {
		// TODO Auto-generated method stub
		
	}

	public List<User> listUser() {
		// TODO Auto-generated method stub
		return null;
	}

	public void setRepository(UserRepository repository) {
		this.repository = repository;
	}
	
}
