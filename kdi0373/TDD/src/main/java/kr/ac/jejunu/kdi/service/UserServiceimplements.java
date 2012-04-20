package kr.ac.jejunu.kdi.service;

import java.util.List;

import kr.ac.jejunu.kdi.model.User;
import kr.ac.jejunu.kdi.repository.UserRepository;

import org.springframework.stereotype.Component;

@Component
public class UserServiceimplements implements UserService {
	private UserRepository repository;
	@Override
	public User get(String id) {
		User user = repository.findById(id);
		return user;
	}

	public void romoveById(String id) {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public void addUser(User user) {
		User foundUser = repository.findById(user.getId());
	}

	public void modifyUser(User user) {
		// TODO Auto-generated method stub
		
	}

	public List<User> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	public void setUserRepository(UserRepository repository) {
		this.repository = repository;
	}
	
}
