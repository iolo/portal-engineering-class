package kr.ac.jejunu.sj.controller;

import java.util.List;

import kr.ac.jejunu.sj.model.User;
import kr.ac.jejunu.sj.service.UserService;

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
		
		return userService.listUser();
		
	}
}
