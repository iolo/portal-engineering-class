package kr.ac.jejuuniv.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Service;

import kr.ac.jejuuniv.exception.DataNotFoundException;
import kr.ac.jejuuniv.model.User;
import kr.ac.jejuuniv.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {
	@Autowired
	UserRepository userRepository;
	
	public UserServiceImpl() {
		
	}
	
	public UserServiceImpl(UserRepository userRepository) {
		this.userRepository = userRepository;
	}
	
	public List<User> list() {
		return userRepository.findAll();
	}

	public User get(String id) {
		if(userRepository.findById(id) == null){
			throw new DataNotFoundException();
		}
		else
			return userRepository.findById(id);
	}

	public User add(User user) {
		if(userRepository.findById(user.getId()) != null)
			throw new DuplicateKeyException(null);
		else
			return userRepository.insert(user);
	}

	public User modify(User user) {
		if(userRepository.findById(user.getId()) == null)
			throw new DataNotFoundException();
		else 
			return userRepository.update(user);
	}

	public void remove(String id) {
		if(get(id) != null)
			userRepository.delete(id);
		else 
			throw new DataNotFoundException();
	}

}
