package kr.ac.jejunu.rabbit.controller;

import java.util.List;

import kr.ac.jejunu.rabbit.model.User;
import kr.ac.jejunu.rabbit.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/list")
public class UserList {
	
	@Autowired
	private UserService userService;
	
	@RequestMapping
	public List<User> action() {
		 return userService.list();
	}
}
