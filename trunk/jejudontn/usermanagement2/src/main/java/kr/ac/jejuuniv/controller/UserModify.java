package kr.ac.jejuuniv.controller;


import kr.ac.jejununiv.model.User;
import kr.ac.jejuuniv.Service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/modify")
public class UserModify {
	@Autowired
	private UserService userService;
	@RequestMapping(method = RequestMethod.GET)
	public User userGet(@RequestParam("id") String id){
		return userService.findById(id);
	}
	@RequestMapping(method = RequestMethod.POST)
	public String userModify(@RequestParam("id")  String id,  @RequestParam("name") String name, @RequestParam("password") String password) {	
		userService.userModify(id, name, password);
		return "redirect:/list";
	}
	
	

}

