package kr.ac.jejuuniv.controller.service.user;

import kr.ac.jejuuniv.model.user.User;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/service/unFollow")
public class UnFollowController {
	@RequestMapping(value = "/followingPage", method = RequestMethod.GET)
	public String action4FollowingPage(@RequestParam String userId,
			@RequestParam String targetId) {
		unFollow(userId, targetId);
		return "redirect:/service/user/" + userId + "/following";
	}

	@RequestMapping(value = "/followerPage", method = RequestMethod.GET)
	public String action4UnFollowPage(@RequestParam String userId,
			@RequestParam String targetId) {
		unFollow(userId, targetId);
		return "redirect:/service/user/" + userId + "/following";
	}
	@RequestMapping(value = "/allUser", method = RequestMethod.GET)
	public String action4AllUser(@RequestParam String userId,
			@RequestParam String targetId) {
		unFollow(userId, targetId);
		return "redirect:/service/user/" + userId + "/allUser";
	}

	private void unFollow(String userId, String targetId) {
		new User().findUserById(userId).unFollowUserById(targetId);
	}
}