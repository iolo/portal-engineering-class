package kr.ac.jejuuniv.controller;


import kr.ac.jejuuniv.test.User;
import kr.ac.jejuuniv.test.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
@RequestMapping("/modify")
public class UserUpdate {
	
	@Autowired
	private UserService userService;
	@RequestMapping(method = RequestMethod.GET)
	public User userGet(String id){
		return userService.get(id);
	}
	@RequestMapping
	public String userModify(String id,  String name, String password) {	
		userService.modifyUser(id, name, password);
		return "redirect:/list";
	}
}
