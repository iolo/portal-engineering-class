package kr.ac.jejunu.rabbit.service;

import java.util.List;

import kr.ac.jejunu.rabbit.model.User;
import kr.ac.jejunu.rabbit.repository.UserRepository;
import kr.ac.jejunu.rabbit.repository.UserRepositoryEmptyException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
	@Autowired
	private UserRepository userRepository;
	
	static List<User> users;

	@Override
	public User get(String id) {
		User user = userRepository.findById(id);
		if(user == null)
			throw new UserNotFoundException(id);
		return user;
	}

	@Override
	public void removeById(String id) {
		if (userRepository.findById(id) == null)
			throw new UserAlreadyDeleteException(id);
		userRepository.delete(id);
	}

	@Override
	public void addUser(String id, String name, String password) {
		userRepository.insert(id, name, password);
		
	}

	@Override
	public void modifyUser(User user) {
		User foundUser = userRepository.findById(user.getId());
		
		if(foundUser == null)
			throw new UserNotFoundException(user.getId());
		
		userRepository.update(user);
	}

	@Override
	public void setUserRepository(UserRepository repository) {
		this.userRepository = repository;
	}

	@Override
	public List<User> list() {
		List<User> users = userRepository.findAll();
		if (users.isEmpty()) {
			throw new UserRepositoryEmptyException();
		}
		return users;	
	}

	@Override
	public User findById(String id) {
		return userRepository.findById(id);
	}

	@Override
	public void userModify(String id, String name, String password) {
		userRepository.modifyUser(id, name, password);
	}
}
