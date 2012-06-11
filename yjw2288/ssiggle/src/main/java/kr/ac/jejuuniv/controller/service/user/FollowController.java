package kr.ac.jejuuniv.controller.service.user;

import javax.servlet.http.HttpServletRequest;

import kr.ac.jejuuniv.model.user.User;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/service/follow")
public class FollowController {
	@RequestMapping(method = RequestMethod.GET)
	public String action(@RequestParam(value = "userId") String userId,
			@RequestParam(value = "targetId") String targetId,
			HttpServletRequest request) {
		follow(userId, targetId);
		return "redirect:" + request.getHeader("Referer");
	}

	private void follow(String userId, String targetId) {
		new User().findUserById(userId).followUserById(targetId);
	}
}
