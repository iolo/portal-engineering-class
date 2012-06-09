package kr.ac.jejuuniv.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import kr.ac.jejuuniv.model.User;
import kr.ac.jejuuniv.service.UserService;

@Controller
@RequestMapping("/service/delete*")
public class TweetRemoveController {
	@Autowired
	UserService userService;
	
	public TweetRemoveController() {
		
	}
	public TweetRemoveController(UserService userService) {
		this.userService = userService;
	}
	
	@RequestMapping
	public String removeTweetAction(HttpSession session, int tweetId) {
		User user = (User) session.getAttribute("loginUser");
		userService.removeTweet(user.getLoginId(), tweetId);
		return "redirect:/service/personalSns";
	}
}
