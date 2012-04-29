package kr.ac.jejuuniv.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import kr.ac.jejuuniv.exception.DataNotFoundException;
import kr.ac.jejuuniv.model.User;
import kr.ac.jejuuniv.service.UserService;

@Controller
@RequestMapping("/modify")
public class UserModifyController {
	
	UserService userService;
	
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
		modelAndView.setViewName("list");
		return modelAndView;
	}
}
