package kr.ac.jejuuniv.controller;

import kr.ac.jejuuniv.test.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/save")
public class UserCreate {
	
	@Autowired
	private UserService userService;
	
	@RequestMapping
	public String userCreate(String id,String name, String password) {
		 userService.addUser(id, name, password);
		return "redirect:/list";
		
	}

}

