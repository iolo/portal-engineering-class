package kr.ac.jejuuniv.service;

import java.util.List;

import org.springframework.dao.DuplicateKeyException;

import kr.ac.jejuuniv.exception.EmptyDataException;
import kr.ac.jejuuniv.repository.UserRepository;

public class UserServiceImpl implements UserService {

	private UserRepository repository;

	public UserServiceImpl(UserRepository userRepository) {
		this.repository = userRepository;
	}

	public UserServiceImpl() {

	}

	public List<User> list() {
		return repository.findAll();
	}

	public User get(String id) {
		if (repository.findById(id) == null)
			throw new EmptyDataException();
		return repository.findById(id);
	}

	public void save(User user) {
		if (user.getKey() == 0) {
			if (repository.findById(user.getId()) == null) {
				repository.insert(user);
			} else {
				throw new DuplicateKeyException("");
			}
		} else {
			repository.update(user);
		}

	}

	public void delete(String id) {
		repository.delete(id);
	}

}
