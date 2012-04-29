package kr.ac.jejuuniv.controller;

import kr.ac.jejuuniv.service.UserService;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/remove")
public class UserRemoveController {
	UserService userService;
	
	public UserRemoveController() {
		
	}
	
	public UserRemoveController(UserService userService) {
		this.userService = userService;
	}

	@RequestMapping
	public String remove(String id) {
		return "redirect:/list";
	}

}
