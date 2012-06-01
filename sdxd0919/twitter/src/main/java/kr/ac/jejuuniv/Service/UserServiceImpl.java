package kr.ac.jejuuniv.Service;

import kr.ac.jejuuniv.Model.User;
import kr.ac.jejuuniv.Repository.UserRepository;

public class UserServiceImpl implements UserService {

	private UserRepository userRepository;

	public UserServiceImpl() {
	}
	
	public UserServiceImpl(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	public User checkUser(String id, String password) {
		return userRepository.getUserById(id);
	}

	public User getUser(int userNum) {
		return userRepository.findByUserNum(userNum);
	}

	public void addUser(User user) {
		userRepository.insert(user);
	}

	public void update(User user) {
		userRepository.update(user);
	}

}
