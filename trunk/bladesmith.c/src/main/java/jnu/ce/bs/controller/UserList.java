package jnu.ce.bs.controller;

import java.util.List;

import jnu.ce.bs.service.User;
import jnu.ce.bs.service.UserService;

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
		return userService.findAll();
	}
}
