package kr.ac.jejuuniv.controller;

import kr.ac.jejuuniv.model.User;
import kr.ac.jejuuniv.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/modify")
public class UserModify {
	
	@Autowired
	private UserService userService;
	
	@RequestMapping
	public User action(String id) {
		return userService.get(id);
	}
}
