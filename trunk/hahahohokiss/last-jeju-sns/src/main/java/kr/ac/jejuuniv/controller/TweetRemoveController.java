package kr.ac.jejuuniv.controller;

import javax.servlet.http.HttpSession;

import kr.ac.jejuuniv.model.User;
import kr.ac.jejuuniv.service.UserService;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/service/delete*")
public class TweetRemoveController extends BaseFormController {
	
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
