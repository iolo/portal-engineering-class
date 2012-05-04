package kr.ac.jejuuniv;

import java.util.List;

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
	public void create(User user) {
		userRepository.insert(user);
		
	}

	@Override
	public void remove(String id) {
		userRepository.delete(id);
	}

	@Override
	public User get(String id) {
		return userRepository.findById(id);
	}

}