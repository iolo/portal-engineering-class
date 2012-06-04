package kr.ac.jejuuniv.controller.user;

import kr.ac.jejuuniv.model.user.User;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/service/follow")
public class FollowController {
	@RequestMapping(value = "/allUser", method = RequestMethod.GET)
	public String action4AllUser(@RequestParam String userId,
			@RequestParam String targetId) {
		new User().findUserById(userId).followUserById(targetId);
		return "redirect:/service/user/" + userId + "/allUser";
	}
}
