package kr.ac.jejuuniv.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import kr.ac.jejuuniv.model.User;
import kr.ac.jejuuniv.service.UserService;

@Controller
@RequestMapping("/modify")
public class UserModifyController {
	UserService userService;
	
	@Autowired
	public UserModifyController(UserService userService) {
		this.userService = userService;
	}
	
	@RequestMapping
	public User modify(String id) {
		return userService.get(id);
	}

}
