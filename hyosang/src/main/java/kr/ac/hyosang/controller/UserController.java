package kr.ac.hyosang.controller;

import javax.servlet.http.HttpSession;

import kr.ac.hyosang.model.User;
import kr.ac.hyosang.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class UserController {
	@Autowired
	UserService userService;
	
	@RequestMapping(value = "/join")
	public String join() {
		return "join";
	}
	
	@RequestMapping(value = "/joinprocess")
	public String joinProcess(@ModelAttribute("user") User user) {
		user.setUserId(user.getUserId());
		user.setPassword(user.getPassword());
		user.setUserName(user.getUserName());
		user.setUserInfo(user.getUserInfo());
		user.setUserImagePath("임의 경로");
		userService.userJoin(user);
		
		return "redirect:/";
	}
	
	@RequestMapping(value = "/login")
	public String login() {
		return "login";
	}

	@RequestMapping(value = "/loginprocess")
	public String loginProcess(User user, HttpSession session) {
		User loginUser = userService.loginCheck(user.getUserId(), user.getPassword());
		if (loginUser != null) {
			session.setAttribute("user", loginUser);
			return "redirect:/";
		} else {
			return "redirect:/login";
		}
	}
}
