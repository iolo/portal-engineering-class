package kr.ac.jejuuniv.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.ac.jejuuniv.Model.User;
import kr.ac.jejuuniv.Repository.UserRepository;
import kr.ac.jejuuniv.Service.Exception.UserNotFoundException;

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
		if(userRepository.findByUserNum(user.getUserNum()) == null){
			throw new UserNotFoundException();
		}else{
			userRepository.update(user);
		}
	}

	public List<User> getAllUser() {
		return userRepository.getAll();
	}

}
