package kr.ac.jejuuniv.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import kr.ac.jejuuniv.service.UserService;

@Controller
@RequestMapping("/")
public class HomeController {
	
	public HomeController() {
		
	}
	public HomeController(UserService userService) {
		
	}
	@RequestMapping
	public String action() {
		return "redirect:/list";
	}
}
