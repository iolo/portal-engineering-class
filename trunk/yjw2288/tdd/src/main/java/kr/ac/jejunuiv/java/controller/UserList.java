package kr.ac.jejunuiv.java.controller;

import java.util.List;

import kr.ac.jejuuniv.java.User;
import kr.ac.jejuuniv.java.userservice.UserService;

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