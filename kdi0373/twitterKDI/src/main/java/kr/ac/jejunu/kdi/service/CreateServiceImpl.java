package kr.ac.jejunu.kdi.service;

import kr.ac.jejunu.kdi.model.CreateUser;
import kr.ac.jejunu.kdi.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public  class CreateServiceImpl implements CreateService {

	@Autowired
	UserRepository userRepository;
	
	@Override
	public void createUser(String id, String password, String name, String memo, String image){
		CreateUser user = new CreateUser(id, password, name, memo, image);
		userRepository.createUser(user);
	}
}
