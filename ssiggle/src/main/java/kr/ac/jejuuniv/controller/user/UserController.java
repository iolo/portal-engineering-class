package kr.ac.jejuuniv.controller.user;

import java.util.List;

import kr.ac.jejuuniv.model.ssiggle.Ssiggle;
import kr.ac.jejuuniv.model.user.User;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/user")
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
	
	//TODO : 팔로잉, 팔로워 리스트 처리할 컨트롤러
	@RequestMapping("/{userId}/following")
	public String actionFollowing(@PathVariable String userId) {
		return "main";
	}
	@RequestMapping("/{userId}/follower")
	public String actionFollower(@PathVariable String userId) {
		return "main";
	}
}
