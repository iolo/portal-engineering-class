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
public class UserListController {
	@Autowired
	private UserService userService;
	
	@Autowired
	private FollowService followService;
	
	@RequestMapping("follow.do") 
	public ModelAndView follow(String target, HttpServletRequest request){
		followService.follow(target, (String)request.getSession().getAttribute("LoginId"));
		return new ModelAndView("redirect:" + request.getSession().getAttribute("ListPage"));
	}
	
	@RequestMapping("unfollow.do")
	public ModelAndView unfollow(String target, HttpServletRequest request) {
		followService.unfollow(target, (String)request.getSession().getAttribute("LoginId"));
		return new ModelAndView("redirect:" + request.getSession().getAttribute("ListPage"));
	}
	
	@RequestMapping("userlist_all")
	public ModelAndView viewAll(HttpServletRequest request) {
		request.getSession().setAttribute("ListPage", "userlist_all");
		
		ModelAndView mav = new ModelAndView("userlist_page");
		mav.addObject("ListTitle", "모든 사용자");
				
		List<UserModel> users = userService.getList((String)request.getSession().getAttribute("LoginId"));
		List<String> followList = followService.getFollowing((String)request.getSession().getAttribute("LoginId"));
		
		for (UserModel user : users) {
			user.setFollow(followList.contains(user.getId()));
			System.out.println(user.isFollow());
		}
		
		mav.addObject("users", users);
		
		return mav;	
	}
	
	@RequestMapping("userlist_following")
	public ModelAndView viewFollowing(HttpServletRequest request) {
		request.getSession().setAttribute("ListPage", "userlist_following");
		
		ModelAndView mav = new ModelAndView("userlist_page");
		mav.addObject("ListTitle", "Following 사용자");
		
		List<UserModel> users = userService.getFollowingList((String)request.getSession().getAttribute("LoginId"));
		for(UserModel user : users) {
			user.setFollow(true);
		}
		
		mav.addObject("users", users);
		return mav;
	}
	
	@RequestMapping("userlist_follower")
	public ModelAndView viewFollower(HttpServletRequest request) {
		request.getSession().setAttribute("ListPage", "userlist_follower");
		
		ModelAndView mav = new ModelAndView("userlist_page");
		mav.addObject("ListTitle", "Follower 사용자");
				
		List<UserModel> users = userService.getFollowerList((String)request.getSession().getAttribute("LoginId"));
		List<String> followList = followService.getFollowing((String)request.getSession().getAttribute("LoginId"));
		
		for (UserModel user : users) {
			user.setFollow(followList.contains(user.getId()));
			System.out.println(user.isFollow());
		}
		
		mav.addObject("users", users);
		
		return mav;	
	}
	
}
