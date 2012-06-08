package kr.ac.jejuuniv.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import kr.ac.jejuuniv.model.Tweet;
import kr.ac.jejuuniv.model.User;
import kr.ac.jejuuniv.service.UserService;

import org.springframework.web.servlet.ModelAndView;

public class PersonalController {
	
	UserService userService;
	public PersonalController(UserService userService) {
		this.userService = userService;
	}
	public PersonalController() {
		
	}
	
	public ModelAndView action(HttpSession session) {
		ModelAndView modelAndView = new ModelAndView();
		User user = (User) session.getAttribute("loginUser");
		List<Tweet> tweets = userService.getTweets(user.getLoginId());
		modelAndView.addObject("tweets", tweets);
		modelAndView.setViewName("/service/personalSns");
		return modelAndView;
	}

}
