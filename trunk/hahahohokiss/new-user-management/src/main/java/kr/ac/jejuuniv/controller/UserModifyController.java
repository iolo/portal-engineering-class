package kr.ac.jejuuniv.controller;

import kr.ac.jejuuniv.exception.DataNotFoundException;
import kr.ac.jejuuniv.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/modify")
public class UserModifyController {
	@Autowired
	UserService userService;
	
	public UserModifyController() {
		
	}
	
	public UserModifyController(UserService userService) {
		this.userService = userService;
	}
	
	@RequestMapping
	public ModelAndView modify(String id) {
		ModelAndView modelAndView = new ModelAndView();
		try{
			modelAndView.addObject(userService.get(id));
			
		}catch (DataNotFoundException exception) {
			modelAndView.setViewName("redirect:/modify");
			return modelAndView;
		}
		modelAndView.setViewName("redirect:/list");
		return modelAndView;
	}
}
