package kr.ac.jejunu.sj.service;

import java.util.List;

import kr.ac.jejunu.sj.model.User;
import kr.ac.jejunu.sj.repository.UserRepository;

import org.springframework.stereotype.Component;

@Component
public class UserServiceImpl implements UserService {

	private UserRepository repository;

	@Override
	public void setRepository(UserRepository repository) {
		this.repository = repository;
	}

	@Override
	public User get(String id) {
		User user = repository.findById(id);
		if (user == null) {
			throw new UserNotExistException();
		}

		return user;
	}

	@Override
	public void removeById(String id) {
		if(repository.findById(id) == null){
			throw new UserNotExistException();
		}
		
		repository.delete(id);
	}

	@Override
	public void addUser(User user) {
		User preUser = repository.findById(user.getId());
		if(preUser != null){
			throw new DuplicateUserException();
		}
		
		
		repository.insert(user);
	}

	@Override
	public void modifyUser(User user) {
		User newUser = repository.findById(user.getId());
		if(newUser == null){
			throw new UserNotExistException();
		}
		
		newUser.setName(user.getName());
		newUser.setPassword(user.getPassword());
		
		repository.update(newUser);
	}

	@Override
	public List<User> listUser() {
		List<User> users = repository.findAll();
		if (users.isEmpty()) {
			throw new UserEmptyException();
		}

		return repository.findAll();
	}

}
