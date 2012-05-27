package kr.ac.jejunu.rabbit.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.ac.jejunu.rabbit.model.User;
import kr.ac.jejunu.rabbit.repository.UserRepository;

@Service
public class UserServiceImp implements UserService{

	@Autowired
	UserRepository userRepository;
	
	@Override
	public void insert(User user) {
		if (user.getUserid() == null)
			userRepository.insert(user);
		else
			userRepository.update(user);
	}

	@Override
	public void delete(String userid) {
		userRepository.delete(userid);
	}

	@Override
	public User get(String userid) {
		return userRepository.findById(userid);
	}

	@Override
	public List<User> List() {
		List<User> users = userRepository.findAll();
		return users;
	}


}
