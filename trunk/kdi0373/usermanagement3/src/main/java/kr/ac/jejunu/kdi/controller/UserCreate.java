package kr.ac.jejunu.kdi.controller;

import kr.ac.jejunu.kdi.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping ("/save")
public class UserCreate {
	
	@Autowired
	private UserService userService;
	
	@RequestMapping
	public String createUser(String id, String name, String password){
		userService.userCreate(id, name, password);
		return "redirect:/list";
	}

}
