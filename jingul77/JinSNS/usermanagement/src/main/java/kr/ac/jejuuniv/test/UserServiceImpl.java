package kr.ac.jejuuniv.test;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository repository = new UserRepositoryImpl();
	
	public void setUserRepository(UserRepository repository) {
		this.repository = repository;
	}

	@Override
	public User get(String id) {
		
		return repository.findById(id);
	}

	@Override
	public void removeById(String id) {
		repository.delete(id);
	}

	@Override
	public void addUser(User user) {
		User foundUser=repository.findById(user.getId());	
	}

	@Override
	public void modifyUser(String id, String name, String password) {
		repository.update(id, name, password);
	}

	@Override
	public List<User> findAll() {
		List<User> foundusers = repository.findAll();
		return foundusers;
	}

	@Override
	public List<User> list() {
		
		return repository.findAll();
	}

	@Override
	public void addUser(String id, String name, String password) {
		repository.addUser(id, name, password);
	}

}
