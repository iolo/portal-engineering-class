package jnu.ce.bs.userservice;

import java.util.List;
import org.springframework.dao.DuplicateKeyException;

public class UserServiceImpl implements UserService {

	private UserRepository userRepository;

	public UserServiceImpl(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	public List<User> findAll() {
		if (userRepository.findAll() == null) {
			throw new dataNotFoundException();
		} else
			return userRepository.findAll();
	}

	public List<User> get(String userId) {
		if (userRepository.findById(userId) == null) {
			throw new userNotFoundException();
		} else
			return userRepository.findById(userId);
	}

	public List<User> add(String id, String name, String password) {
		if (userRepository.indexedIdCheck(id)) {
			throw new DuplicateKeyException("존재하는 아이디입니다.");
		} else
			return userRepository.createUesr(id, name, password);
	}

	public List<User> delete(String userId) {
		if (!userRepository.indexedIdCheck(userId)) {
			return userRepository.deleteById(userId);
		} else
			throw new userNotFoundException();
	}

	public List<User> modify(String userId, String modifyName,
			String modifyPassword) {
		if (!userRepository.indexedIdCheck(userId)) {
			return userRepository.modifyById(userId, modifyName, modifyPassword);
		} else
			throw new userNotFoundException();
	}
	
}
