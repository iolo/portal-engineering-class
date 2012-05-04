package kr.ac.jejuuniv.controller;

import kr.ac.jejuuniv.exception.DataNotFoundException;
import kr.ac.jejuuniv.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/remove")
public class UserRemoveController {
	@Autowired
	UserService userService;
	
	public UserRemoveController() {
		
	}
	
	public UserRemoveController(UserService userService) {
		this.userService = userService;
	}

	@RequestMapping
	public String remove(String id) {
		try {
			userService.remove(id); 
		} catch (DataNotFoundException exception) {
			return "redirect:/list";
		}
		return "redirect:/list";
	}

}