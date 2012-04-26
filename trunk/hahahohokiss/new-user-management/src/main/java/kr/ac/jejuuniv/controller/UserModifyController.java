package kr.ac.jejuuniv.controller;

import kr.ac.jejuuniv.model.User;
import kr.ac.jejuuniv.service.UserService;

public class UserModifyController {
	UserService userService;
	
	public UserModifyController(UserService userService) {
		this.userService = userService;
	}
	
	public User modify(String id) {
		return userService.get(id);
	}

}
