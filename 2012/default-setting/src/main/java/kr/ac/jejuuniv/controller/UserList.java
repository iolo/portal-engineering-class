package kr.ac.jejuuniv.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import kr.ac.jejuuniv.model.User;
import kr.ac.jejuuniv.service.UserService;

@Controller
@RequestMapping("/list")
public class UserList {	
	@Autowired
	private UserService userService;
	
	@RequestMapping
	public List<User> action() {
		userService.findAll();
		return null;
	}
}
