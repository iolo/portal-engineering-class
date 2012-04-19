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

	@Override
	public List<User> list() {
		return userRepository.findAll();
	}

	@Override
	public User get(String id) {
		return userRepository.findById(id);
	}


	@Override
	public void save(User user) {
		if (get(user.getId()) == null)
			userRepository.insert(user);
		else
			userRepository.update(user);
	}

	@Override
	public void remove(String id) {
		userRepository.delete(id);
	}

}
