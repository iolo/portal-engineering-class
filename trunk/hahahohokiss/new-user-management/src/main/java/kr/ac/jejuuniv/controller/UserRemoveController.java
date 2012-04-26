package kr.ac.jejuuniv.controller;

import org.springframework.web.servlet.ModelAndView;

import kr.ac.jejuuniv.service.UserService;

public class UserRemoveController {
	

	public String remove(String id) {
		return "redirect/:list";
	}

}
