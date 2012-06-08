package kr.ac.jejuuniv.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import kr.ac.jejuuniv.model.UserModel;
import kr.ac.jejuuniv.service.FollowService;
import kr.ac.jejuuniv.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class UserviewController {
	@Autowired
	private UserService userService;
	
	@Autowired
	private FollowService followService;
	
	@RequestMapping("followTEST") 
	public ModelAndView followTEST(String target, HttpServletRequest request){
		followService.follow(target, (String)request.getSession().getAttribute("LoginId"));
		return new ModelAndView("redirect:viewAll");
	}
	
	@RequestMapping("unfollowTEST")
	public ModelAndView unfollowTEST(String target, HttpServletRequest request) {
		followService.unfollow(target, (String)request.getSession().getAttribute("LoginId"));
		return new ModelAndView("redirect:viewAll");
	}
	
	@RequestMapping("viewAll")
	public ModelAndView viewAll(HttpServletRequest request) {
		ModelAndView mav = new ModelAndView("users_page");
		mav.addObject("titleString", "모든 사용자");
				
		List<UserModel> users = userService.getList();
		List<String> followList = followService.getFollowing((String)request.getSession().getAttribute("LoginId"));
		
		for (UserModel user : users) {
			user.setFollow(followList.contains(user.getId()));
			System.out.println(user.isFollow());
		}
		
		mav.addObject("users", users);
		
		return mav;	
	}
	
	
}
