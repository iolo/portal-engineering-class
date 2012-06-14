package kr.ac.jejunu.rabbit.contoller;

import java.util.List;

import kr.ac.jejunu.rabbit.model.AllFollow;
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
	List<AllFollow> allfollowerUser;

	@RequestMapping
	public String action(@RequestParam(value = "userid") String userid, Model model) {
		model.addAttribute("loginUser", userService.UserGet(userid));
		
		userService.followerList(userid);
		model.addAttribute("user", userService.followerList(userid));		
		allfollowerUser = userService.setFollow(userService.getAllUser(userid), userService.getAllFollow(userid));		
		model.addAttribute("following", allfollowerUser);
		
		return "follower";
	}
}
