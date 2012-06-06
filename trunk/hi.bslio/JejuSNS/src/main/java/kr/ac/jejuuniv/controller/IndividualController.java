package kr.ac.jejuuniv.controller;

import kr.ac.jejuuniv.model.UserModel;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller

public class IndividualController {
	@RequestMapping("Individual")
	public ModelAndView individual(UserModel user) {
		ModelAndView modelView = new ModelAndView("individualPage");
		modelView.addObject("id", user.getId());
		System.out.println(user.getId());
		return modelView;
	}
	
	@RequestMapping("writeSns")
	public ModelAndView writeSns() {
		
		return new ModelAndView("writeSns");
	}
}
