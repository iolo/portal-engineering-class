package kr.ac.jejunu.rabbit.contoller;

import kr.ac.jejunu.rabbit.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/follower")
public class FollowerController {
	@Autowired
	private UserService userService;

	@RequestMapping
	public String action(@RequestParam(value = "userid") String userid, Model model) {
		model.addAttribute("loginUser", userService.UserGet(userid));
		model.addAttribute("following", userService.followerList(userid));
		System.out.println(userService.followerList(userid).get(0));
		return "follower";
	}
}
