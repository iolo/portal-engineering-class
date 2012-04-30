package kr.ac.jejuuniv.controller;

import kr.ac.jejuuniv.model.User;
import kr.ac.jejuuniv.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/update")
public class UserUpdateController {
	@Autowired
	UserService userService;
	
	public UserUpdateController() {
		
	}
	
	public UserUpdateController(UserService userService) {
		this.userService = userService;
	}

	@RequestMapping
	public String update(User user) {
		userService.modify(user);
		return "redirect:/list";
	}

}
