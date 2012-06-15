package jnu.ce.bs.k.controller;

import java.util.HashMap;
import java.util.Map;

import jnu.ce.bs.k.model.User;
import jnu.ce.bs.k.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@SessionAttributes("User")
@RequestMapping
public class FollowController {

	@Autowired
	private UserService userService;

	@RequestMapping(method = { RequestMethod.POST, RequestMethod.GET }, value = "/follow")
	public String follow(@ModelAttribute("User") User user,
			@RequestParam("userId") String userId) {
		Map<String, String> map = new HashMap<String, String>();
		map.put("userId", user.getId());
		map.put("followId", userId);

		userService.follow(map);

		return "redirect:/users.bs";
	}

	@RequestMapping(method = { RequestMethod.POST, RequestMethod.GET }, value = "/unfollow")
	public String unFollow(@ModelAttribute("User") User user,
			@RequestParam("userId") String userId) {
		Map<String, String> map = new HashMap<String, String>();
		map.put("userId", user.getId());
		map.put("followId", userId);

		userService.unfollow(map);

		return "redirect:/users.bs";
	}

	@RequestMapping(method = { RequestMethod.POST, RequestMethod.GET }, value = "/fwingfollow")
	public String fwingFollow(@ModelAttribute("User") User user,
			@RequestParam("userId") String userId) {
		Map<String, String> map = new HashMap<String, String>();
		map.put("userId", user.getId());
		map.put("followId", userId);

		userService.follow(map);

		return "redirect:/following.bs";
	}

	@RequestMapping(method = { RequestMethod.POST, RequestMethod.GET }, value = "/fwingunfollow")
	public String fwingUnFollow(@ModelAttribute("User") User user,
			@RequestParam("userId") String userId) {
		Map<String, String> map = new HashMap<String, String>();
		map.put("userId", user.getId());
		map.put("followId", userId);

		userService.unfollow(map);

		return "redirect:/following.bs";
	}

	@RequestMapping(method = { RequestMethod.POST, RequestMethod.GET }, value = "/fwerfollow")
	public String fwerFollow(@ModelAttribute("User") User user,
			@RequestParam("userId") String userId) {
		Map<String, String> map = new HashMap<String, String>();
		map.put("userId", user.getId());
		map.put("followId", userId);

		userService.follow(map);

		return "redirect:/follower.bs";
	}

	@RequestMapping(method = { RequestMethod.POST, RequestMethod.GET }, value = "/fwerunfollow")
	public String fwerUnFollow(@ModelAttribute("User") User user,
			@RequestParam("userId") String userId) {
		Map<String, String> map = new HashMap<String, String>();
		map.put("userId", user.getId());
		map.put("followId", userId);

		userService.unfollow(map);

		return "redirect:/follower.bs";
	}
}
