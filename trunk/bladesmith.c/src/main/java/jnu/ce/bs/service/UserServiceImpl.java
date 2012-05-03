package jnu.ce.bs.service;

import java.util.List;

import jnu.ce.bs.exception.dataNotFoundException;
import jnu.ce.bs.exception.duplicationException;
import jnu.ce.bs.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
	@Autowired
	private UserRepository userRepository;

	public UserServiceImpl(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	public UserServiceImpl() {

	}

	public List<User> findAll() {
		if (userRepository.findAll() == null) {
			throw new dataNotFoundException();
		} else
			return userRepository.findAll();
	}

	public User get(String userId) {
		if (userRepository.findById(userId) == null) {
			throw new duplicationException();
		} else
			return userRepository.findById(userId);
	}

	@Override
	public void add(String userId, String name, String password) {
		if (!userRepository.indexedIdCheck(userId)) {
			throw new duplicationException();
		} else
			userRepository.createUesr(userId, name, password);
	}

	public void delete(String userId) {
			userRepository.deleteById(userId);
	}

	public void modify(String userId, String modifyName,
			String modifyPassword) {
		if (!userRepository.indexedIdCheck(userId)) {
			 userRepository
					.modifyById(userId, modifyName, modifyPassword);
		} else
			throw new duplicationException();
	}

	@Override
	public Boolean duplicationIdCheck(String userId) {
		return userRepository.indexedIdCheck(userId);
	}
}
