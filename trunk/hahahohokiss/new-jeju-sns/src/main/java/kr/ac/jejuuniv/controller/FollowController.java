package kr.ac.jejuuniv.controller;

import javax.servlet.http.HttpSession;

import kr.ac.jejuuniv.model.User;
import kr.ac.jejuuniv.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("service/follow*")
public class FollowController {

	@Autowired
	UserService userService;
	
	@RequestMapping
	public String followAction(String followingId, HttpSession session) {
		User user = (User) session.getAttribute("loginUser");
		userService.addFollow(user.getLoginId(), followingId);
		return "redirect:/service/mainSns";
	}
}
