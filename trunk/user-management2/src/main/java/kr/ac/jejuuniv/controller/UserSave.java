package kr.ac.jejuuniv.controller;


import kr.ac.jejuuniv.model.User;
import kr.ac.jejuuniv.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/save")
public class UserSave {
	@Autowired
	UserService userService;

	@RequestMapping
	public String save(User user){
		userService.save(user);
		return "redirect:/list";
	}
}
