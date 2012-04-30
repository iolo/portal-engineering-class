package kr.ac.jejuuniv.service;

import java.util.List;

import kr.ac.jejuuniv.model.User;
import kr.ac.jejuuniv.repository.UserRepository;

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
		userRepository.delete(id);
	}

	public void save(User user) {
		if(userRepository.findById(user.getId()) == null){
			userRepository.insert(user);
		}else{
			userRepository.update(user);
		}
	}

	public User getUser(String id) {
		return userRepository.findById(id);
	}

}
