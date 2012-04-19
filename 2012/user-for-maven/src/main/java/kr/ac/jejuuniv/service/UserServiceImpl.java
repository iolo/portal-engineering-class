package kr.ac.jejuuniv.service;

import java.util.List;

import kr.ac.jejuuniv.model.User;
import kr.ac.jejuuniv.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;

	public List<User> list() {
		return userRepository.findAll();
	}

	public User get(String id) {
		return userRepository.findById(id);
	}


	public void save(User user) {
		if (get(user.getId()) == null)
			userRepository.insert(user);
		else
			userRepository.update(user);
	}

	public void remove(String id) {
		userRepository.delete(id);
	}


}
