package kr.ac.jejuuniv.controller;

import java.util.List;

import kr.ac.jejuuniv.model.AllUsers;
import kr.ac.jejuuniv.model.User;
import kr.ac.jejuuniv.service.FollowService;
import kr.ac.jejuuniv.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@RequestMapping("/following")
@SessionAttributes("user")
public class FollowingController {
	@Autowired
	FollowService followService;
	@Autowired
	UserService userService;

	@RequestMapping()
	public List<AllUsers> follower(@ModelAttribute("user") User user) {

		return followService.getFollowing(user.getId());

	}

	@RequestMapping("/changefollow")
	public String followuser(@ModelAttribute("user") User user,
			@RequestParam("follow") String follow,
			@RequestParam("followId") String followid) {
		userService.FollowUser(user.getId(), follow, followid);

		return "redirect:/following";

	}

}
