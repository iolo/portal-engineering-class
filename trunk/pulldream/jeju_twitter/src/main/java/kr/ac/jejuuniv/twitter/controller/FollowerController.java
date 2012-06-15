package kr.ac.jejuuniv.twitter.controller;

import javax.servlet.http.HttpServletRequest;

import kr.ac.jejuuniv.twitter.service.TwitterService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class FollowerController {

	@Autowired
	private TwitterService twitterService;
	
	@RequestMapping("follower")
	public ModelAndView goToMainWithFollowingList(HttpServletRequest reqeust){
		return new ModelAndView("main","pageType","/followerlist");
	}
	
	//팔로어 리스트 보여지기
	@RequestMapping("followerlist")
	public ModelAndView test(HttpServletRequest reqeust){
		String id = (String)reqeust.getSession().getAttribute("loginID");
		ModelAndView followListView = new ModelAndView();
		followListView.setViewName("/twitt/followerlist");
		followListView.addObject("followerList",twitterService.getFollowerList(id));
		return followListView;
	}

}
