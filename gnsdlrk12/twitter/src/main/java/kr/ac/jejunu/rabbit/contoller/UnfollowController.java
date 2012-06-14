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
@RequestMapping("/unfollow")
public class UnfollowController {
	@Autowired
	UserService userService;
	List<AllFollow> allfollowerUser;
	String checkvalue = null;
	
	@RequestMapping
	public String unfollow(@RequestParam(value="userid") String userid, @RequestParam(value="followerid") String followerid,
			@RequestParam(value="page") int page, Model model){
		if(page == 1){
			userService.UserUnfollow(userid, followerid);
			model.addAttribute("loginUser", userService.UserGet(userid));
			model.addAttribute("user", userService.followingList(userid));
			checkvalue = "following";
		}
		if(page == 2 || page == 3){
			if (page == 2){
				userService.UserUnfollow(userid, followerid);
				model.addAttribute("loginUser", userService.UserGet(userid));			
				userService.followerList(userid);
				model.addAttribute("user", userService.followerList(userid));		
				allfollowerUser = userService.setFollow(userService.getAllUser(userid), userService.getAllFollow(userid));		
				model.addAttribute("following", allfollowerUser);				
			}
			else if (page == 3){
				userService.userFollow(userid, followerid);
				model.addAttribute("loginUser", userService.UserGet(userid));			
				userService.followerList(userid);
				model.addAttribute("user", userService.followerList(userid));		
				allfollowerUser = userService.setFollow(userService.getAllUser(userid), userService.getAllFollow(userid));		
				model.addAttribute("following", allfollowerUser);	
			}
			checkvalue = "follower";
		}
		return checkvalue;
	}
}
