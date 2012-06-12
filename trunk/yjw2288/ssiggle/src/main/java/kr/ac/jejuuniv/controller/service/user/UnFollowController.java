package kr.ac.jejuuniv.controller.service.user;

import javax.servlet.http.HttpServletRequest;

import kr.ac.jejuuniv.model.user.User;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/service/unFollow")
public class UnFollowController {
	@RequestMapping(method = RequestMethod.GET)
	public String action(@CookieValue("userId") String userId,
			@RequestParam("targetId") String targetId,
			HttpServletRequest request) {
		unFollow(userId, targetId);
		return "redirect:" + request.getHeader("Referer");
	}

	private void unFollow(String userId, String targetId) {
		new User().findUserById(userId).unFollowUserById(targetId);
	}
}