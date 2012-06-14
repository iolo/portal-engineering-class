package kr.ac.jejuuniv.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import kr.ac.jejuuniv.model.Tweet;
import kr.ac.jejuuniv.model.User;
import kr.ac.jejuuniv.service.UserService;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/service/personalSns")
public class PersonalController extends BaseFormController {
	public PersonalController(UserService userService) {
		this.userService = userService;
	}
	public PersonalController() {
		
	}
	@RequestMapping
	public ModelAndView action(HttpSession session) {
		ModelAndView modelAndView = new ModelAndView();
		User user = (User) session.getAttribute("loginUser");
		List<Tweet> tweets = userService.getTweets(user.getLoginId());
		
		user = userService.getUser(user.getLoginId());
		session.setAttribute("loginUser", user);
		modelAndView.addObject("tweets", tweets);
		modelAndView.setViewName("/service/personalSns");
		return modelAndView;
	}

}
