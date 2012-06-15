package kr.ac.jejuuniv.controller;

import javax.servlet.http.HttpSession;

import kr.ac.jejuuniv.model.User;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/service/userform")
public class UserFormController {
	
	@RequestMapping
	public ModelAndView userFormAction(HttpSession session) {
		ModelAndView modelAndView = new ModelAndView();
		User user = (User) session.getAttribute("loginUser");
		modelAndView.addObject("loginUser", user);
		modelAndView.setViewName("/service/userform");
		return modelAndView;
	}

}
