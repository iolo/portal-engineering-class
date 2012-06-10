package kr.ac.jejuuniv.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import kr.ac.jejuuniv.model.Tweet;
import kr.ac.jejuuniv.model.User;
import kr.ac.jejuuniv.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/service/mainSns")
public class MainSnsController {
	
	@Autowired
	UserService userService;
	
	@RequestMapping
	public ModelAndView action(HttpSession session) {
		ModelAndView modelAndView = new ModelAndView();
		User user = (User) session.getAttribute("loginUser");
		List<Tweet> tweets = userService.getFollowingTweet(user.getLoginId());
		modelAndView.addObject("tweets",tweets);
		modelAndView.setViewName("/service/mainSns");
		return modelAndView;
		
	}
}
