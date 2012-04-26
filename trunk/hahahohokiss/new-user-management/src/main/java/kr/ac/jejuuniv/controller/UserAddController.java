package kr.ac.jejuuniv.controller;

import org.springframework.web.servlet.ModelAndView;

import kr.ac.jejuuniv.model.User;
import kr.ac.jejuuniv.service.UserService;

public class UserAddController {

	UserService userService;
	
	public UserAddController(UserService userService) {
		this.userService = userService;
	}

	public ModelAndView add(User user) {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject(userService.add(user));
		modelAndView.setViewName("/list");
		return modelAndView;
	}
}
