package kr.ac.jejuuniv.controller;

import javax.servlet.http.HttpSession;

import kr.ac.jejuuniv.model.User;
import kr.ac.jejuuniv.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/service/unfollow*")
public class UnFollowController {

	@Autowired
	UserService userService;
	
	@RequestMapping
	public String unFollowAction(String followingId, HttpSession session) {
		User user = (User) session.getAttribute("loginUser");
		System.out.println(followingId);
		userService.removeFollow(user.getLoginId(), followingId);
		return "redirect:/service/mainSns";
	}
}
