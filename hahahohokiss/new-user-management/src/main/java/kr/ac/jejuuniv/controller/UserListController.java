package kr.ac.jejuuniv.controller;

import java.util.List;

import kr.ac.jejuuniv.model.User;
import kr.ac.jejuuniv.service.UserService;

public class UserListController {

	UserService userService;
	
	public UserListController(UserService userService) {
		this.userService = userService;
	}
	
	public List<User> list() {
		return userService.list();
	}

}
