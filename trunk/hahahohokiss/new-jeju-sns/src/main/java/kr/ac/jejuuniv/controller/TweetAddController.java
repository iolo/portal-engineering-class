package kr.ac.jejuuniv.controller;

import javax.servlet.http.HttpSession;

import kr.ac.jejuuniv.model.Tweet;
import kr.ac.jejuuniv.model.User;
import kr.ac.jejuuniv.service.UserService;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/serivce/tweetAdd*")
public class TweetAddController extends BaseFormController {
	public TweetAddController(UserService userService) {
		this.userService = userService;
	}
	public TweetAddController() {
		
	}
	@RequestMapping
	public String addTweetAction(String tweet, String url, HttpSession session) {
		Tweet insertTweet = new Tweet();
		insertTweet.setContents(tweet);
		User user = (User) session.getAttribute("loginUser");
		String userId = user.getLoginId();
		userService.addTweet(userId, insertTweet);
		
		int start = url.indexOf("/service");
		String resultUrl = "redirect:"+url.substring(start);
		return resultUrl;
	}
}
