package kr.ac.jejuuniv.controller;

import javax.servlet.http.HttpServletRequest;
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
	public String unFollowAction(String followingId, HttpSession session, HttpServletRequest request) {
		User user = (User) session.getAttribute("loginUser");
		int subStringStart = request.getHeader("Referer").indexOf("/service");
		String redirectViewName = request.getHeader("Referer").substring(subStringStart);
		userService.removeFollow(user.getLoginId(), followingId);
		return "redirect:/"+redirectViewName;
	}
}
