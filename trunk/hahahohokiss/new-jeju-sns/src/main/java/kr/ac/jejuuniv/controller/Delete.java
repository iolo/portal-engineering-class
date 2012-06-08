package kr.ac.jejuuniv.controller;

import javax.servlet.http.HttpSession;

import kr.ac.jejuuniv.model.User;
import kr.ac.jejuuniv.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/serivce/delete*")
public class Delete {
	
	@Autowired
	UserService userService;
	@RequestMapping
	public String action(HttpSession session, int tweetId) {
		User user = (User) session.getAttribute("loginUser");
		String userId = user.getLoginId();
		userService.removeTweet(userId, tweetId);
		return "redirect:/service/personalSns";
	}
}
