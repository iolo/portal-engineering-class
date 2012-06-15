package kr.ac.jejuuniv.twitter.controller;

import javax.servlet.http.HttpServletRequest;

import kr.ac.jejuuniv.twitter.service.FollowService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class FollowingController {

	@Autowired
	private FollowService followService;
	
	@RequestMapping("following")
	public ModelAndView goToMainWithFollowingList(HttpServletRequest reqeust){
		return new ModelAndView("main","pageType","/followinglist");
	}
	
	//팔로잉리스트 보여지기
	@RequestMapping("followinglist")
	public ModelAndView GetFollowingList(HttpServletRequest reqeust){
		String id = (String)reqeust.getSession().getAttribute("loginID");
		ModelAndView followListView = new ModelAndView();
		followListView.setViewName("/twitt/followinglist");
		followListView.addObject("followingList",followService.getFollowingList(id));
		return followListView;
	}

}
