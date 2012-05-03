package kr.ac.jejuuniv.controller;

import kr.ac.jejuuniv.model.User;
import kr.ac.jejuuniv.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/add")
public class UserAddController {
	
	@Autowired
	UserService userService;
	 
	public UserAddController() {
		
	} 
	public UserAddController(UserService userService) {
		this.userService = userService;
	}

	
	@RequestMapping
	public ModelAndView add(@ModelAttribute User user) {
		ModelAndView modelAndView = new ModelAndView();
		try {
			modelAndView.addObject(userService.add(user));
		} catch (DuplicateKeyException exception) {
			modelAndView.setViewName("create");
			return modelAndView;
		}
		modelAndView.setViewName("redirect:/list");
		return modelAndView;
	}
}
