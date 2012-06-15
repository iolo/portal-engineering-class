package kr.ac.jejuuniv.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import kr.ac.jejuuniv.service.TwitService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/service/follow")
public class FollowController {
	@Autowired
	private TwitService twitService;

	@RequestMapping(method = RequestMethod.GET)
	public String follow(HttpServletRequest request, HttpSession session,
			@RequestParam("followId") String followId) {
		String userId = (String) session.getAttribute("loginId");
		twitService.followUser(userId, followId);
		
		return "redirect:" + request.getHeader("Referer");
	}
}
