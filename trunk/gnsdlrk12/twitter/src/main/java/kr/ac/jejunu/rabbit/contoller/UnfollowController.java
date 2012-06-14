package kr.ac.jejunu.rabbit.contoller;

import kr.ac.jejunu.rabbit.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
@RequestMapping("/unfollow")
public class UnfollowController {
	@Autowired
	UserService userService;
	
	@RequestMapping
	public String unfollow(@RequestParam(value="userid") String userid, @RequestParam(value="followerid") String followerid){
		System.out.println(userid + followerid);
		userService.UserUnfollow(userid, followerid);
		return "following";
	}
}
