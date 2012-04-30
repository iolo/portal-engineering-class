package kr.ac.jejuuniv;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
	@Autowired
	UserRepository userRepository;
	
	public List<User> list() {
		return userRepository.findAll();
	}

	public void remove(String id) {
		userRepository.deleteById(id);
	}

	public void save(User user) {
		userRepository.insert(user);
	}

}
