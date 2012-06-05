package kr.ac.jejuuniv.controller.user;

import java.util.List;

import kr.ac.jejuuniv.controller.UserRow;
import kr.ac.jejuuniv.model.ssiggle.Ssiggle;
import kr.ac.jejuuniv.model.user.User;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/service/user")
public class UserController {
	@RequestMapping("/{userId}")
	public String action(@PathVariable String userId, ModelMap model) {
		User user = new User().findUserById(userId);
		List<Ssiggle> ssiggleList = new Ssiggle()
				.ssiggleListByUserIdDesTime(userId);

		model.addAttribute("user", user);
		model.addAttribute("ssigglelist", ssiggleList);

		return "user";
	}

	@RequestMapping("/{userId}/allUser")
	public String actionAllUser(@PathVariable String userId, ModelMap model) {
		User user = new User().findUserById(userId);

		List<UserRow> rowList = user.markFollowUser(user
				.findAllUserNotExistMe());

		model.addAttribute("user", user);
		model.addAttribute("allUser", rowList);

		return "allUser";
	}

	@RequestMapping("/{userId}/following")
	public String actionFollowing(@PathVariable String userId, ModelMap model) {
		User user = new User().findUserById(userId);

		List<User> userList = user.followingUserList();

		model.addAttribute("user", user);
		model.addAttribute("followingUser", userList);
		return "followingUser";
	}

	@RequestMapping("/{userId}/follower")
	public String actionFollower(@PathVariable String userId, ModelMap model) {
		User user = new User().findUserById(userId);

		List<User> userList = user.followerUserList();

		model.addAttribute("user", user);
		model.addAttribute("followerUser", user.markFollowUser(userList));

		return "followerUser";
	}
}