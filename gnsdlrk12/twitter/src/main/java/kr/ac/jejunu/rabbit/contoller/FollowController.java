package kr.ac.jejunu.rabbit.contoller;

import kr.ac.jejunu.rabbit.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/follow")
public class FollowController {
	@Autowired
	UserService userService;
	
	@RequestMapping
	public String userFollow(@RequestParam(value="userid") String userid, @RequestParam(value="followerid") String followerid){
		userService.UserUnfollow(userid, followerid);
		return "following";
	}
}
