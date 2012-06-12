package kr.ac.jejuuniv.controller.service.user;

import javax.servlet.http.HttpServletRequest;

import kr.ac.jejuuniv.model.user.User;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/service/follow")
public class FollowController {
	@RequestMapping(method = RequestMethod.GET)
	public String action(@CookieValue("loginId") String userId,
			@RequestParam("targetId") String targetId,
			HttpServletRequest request) {

		new User().findUserById(userId).followUserById(targetId);
		return "redirect:" + request.getHeader("Referer");
	}
}
