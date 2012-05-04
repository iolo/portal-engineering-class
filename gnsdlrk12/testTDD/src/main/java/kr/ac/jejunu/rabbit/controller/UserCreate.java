package kr.ac.jejunu.rabbit.controller;

import kr.ac.jejunu.rabbit.model.User;
import kr.ac.jejunu.rabbit.repository.UserRepository;
import kr.ac.jejunu.rabbit.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/create")
public class UserCreate {
	@Autowired
	private UserService userService;
	@Autowired
	private UserRepository userRepository;
	
	public void action(User user){
		userService.addUser(userRepository.findById(user.getId()));
	}
}
