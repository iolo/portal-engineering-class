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
@RequestMapping("/service/unfollow")
public class UnFollowController {
	@Autowired
	private TwitService twitService;

	@RequestMapping(method = RequestMethod.GET)
	public String unfollow(HttpSession session,
			@RequestParam("followId") String followId,
			HttpServletRequest request) {
		String userId = (String) session.getAttribute("loginId");
		twitService.unfollow(userId, followId);

		return "redirect:" + request.getHeader("Referer");
	}
}
