package kr.ac.jejuuniv;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
	@Autowired
	private UserRepository userRepository;

	public List<User> list() {
		return userRepository.findAll();
	}

	public void remove(String id) {
		userRepository.delete(id);
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

}