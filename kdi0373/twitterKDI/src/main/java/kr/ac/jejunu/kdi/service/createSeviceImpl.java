package kr.ac.jejunu.kdi.service;

import kr.ac.jejunu.kdi.model.User;
import kr.ac.jejunu.kdi.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public  class createSeviceImpl implements UserService {

	@Autowired
	UserRepository userRepository;
	
	@Override
	public void createUser(String id, String password, String name, String memo, String image){
		User user = new User(id, password, name, memo, image);
		userRepository.createUser(user);
	}
}
