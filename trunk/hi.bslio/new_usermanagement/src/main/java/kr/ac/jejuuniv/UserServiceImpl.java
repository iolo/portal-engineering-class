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

	// <<5>> create, remove 메소드 구현
	public void create(User user) {
		userRepository.insert(user.getId(), user.getName(), user.getPassword());
	}
	
	public void remove(String id) {
		userRepository.delete(id);
	}

	// <<8>> read 메소드 구현
	public User read(String id) {
		return userRepository.read(id);
	}

	// <<13>> modify 메소드 구현
	public void modify(User user) {
		userRepository.modify(user);
	}

}
