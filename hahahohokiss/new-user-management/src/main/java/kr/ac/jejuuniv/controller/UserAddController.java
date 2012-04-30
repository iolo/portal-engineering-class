package kr.ac.jejuuniv.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import kr.ac.jejuuniv.model.User;
import kr.ac.jejuuniv.service.UserService;

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
	public ModelAndView add(User user) {
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
