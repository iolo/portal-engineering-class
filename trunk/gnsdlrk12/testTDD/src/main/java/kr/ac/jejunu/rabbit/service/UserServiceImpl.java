package kr.ac.jejunu.rabbit.service;

import java.util.List;

import kr.ac.jejunu.rabbit.model.User;
import kr.ac.jejunu.rebbit.repository.UserRepository;

import org.springframework.stereotype.Component;

@Component
public class UserServiceImpl implements UserService {

	private UserRepository repository;

	@Override
	public User get(String id) {
		User user = repository.findById(id);
		if(user == null)
			throw new UserNotFoundException(id);
		return user;
	}

	@Override
	public void removeById(String id) {
		if (repository.findById(id) == null)
			throw new UserAlreadyDeleteException(id);
		repository.delete(id);
	}

	@Override
	public void addUser(User user) {
		User foundUser = repository.findById(user.getId());
		if(foundUser != null)
			throw new DuplicatedUserIdException(foundUser.getId());
		
	}

	@Override
	public void modifyUser(User user) {
		User foundUser = repository.findById(user.getId());
		
		if(foundUser == null)
			throw new UserNotFoundException(user.getId());
		
		repository.update(user);
	}

	@Override
	public void setUserRepository(UserRepository repository) {
		this.repository = repository;
	}

	@Override
	public List<User> findAll() {
		List<User> foundusers = repository.findAll();
		if(foundusers.size() == 0)
			throw new UserRepositoryEmptyException();
		return foundusers;
	}
}
