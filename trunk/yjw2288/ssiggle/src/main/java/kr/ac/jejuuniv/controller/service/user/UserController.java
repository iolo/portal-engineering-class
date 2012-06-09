package kr.ac.jejuuniv.controller.service.user;

import java.util.List;

import kr.ac.jejuuniv.model.ssiggle.Ssiggle;
import kr.ac.jejuuniv.model.user.User;
import kr.ac.jejuuniv.model.user.UserRow;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/service/user")
public class UserController {
	@RequestMapping
	public String action(@CookieValue(value = "loginId") String userId,
			ModelMap model) {
		User user = new User().findUserById(userId);
		List<Ssiggle> ssiggleList = new Ssiggle()
				.ssiggleListByUserIdDesTime(userId);

		model.addAttribute("user", user);
		model.addAttribute("ssigglelist", ssiggleList);

		return "user";
	}

	@RequestMapping("/allUser")
	public String actionAllUser(@CookieValue(value = "loginId") String userId,
			ModelMap model) {
		User user = new User().findUserById(userId);

		List<UserRow> rowList = user.markFollowUser(user
				.findAllUserNotExistMe());

		model.addAttribute("user", user);
		model.addAttribute("allUser", rowList);

		return "allUser";
	}

	@RequestMapping("/following")
	public String actionFollowing(
			@CookieValue(value = "loginId") String userId, ModelMap model) {
		User user = new User().findUserById(userId);

		List<User> userList = user.followingUserList();

		model.addAttribute("user", user);
		model.addAttribute("followingUser", userList);
		return "followingUser";
	}

	@RequestMapping("/follower")
	public String actionFollower(@CookieValue(value = "loginId") String userId,
			ModelMap model) {
		User user = new User().findUserById(userId);

		List<User> userList = user.followerUserList();

		model.addAttribute("user", user);
		model.addAttribute("followerUser", user.markFollowUser(userList));

		return "followerUser";
	}

}