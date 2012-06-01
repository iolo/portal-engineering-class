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
@RequestMapping("/follower")
@SessionAttributes("user")
public class FollowerController {
	@Autowired
	FollowService followService;
	@Autowired
	UserService userService;
	
	@RequestMapping()
	public List<AllUsers> follower(@ModelAttribute User user){
		
		return followService.getFollower(user.getId());
	}
	@RequestMapping("/changefollow")
	public String followuser(@ModelAttribute("user") User user, @RequestParam("follow") String follow, @RequestParam("followId") String followid) {
		userService.Followluser(user.getId() , follow, followid);
		
		return "redirect:/follower";
		
	}

}