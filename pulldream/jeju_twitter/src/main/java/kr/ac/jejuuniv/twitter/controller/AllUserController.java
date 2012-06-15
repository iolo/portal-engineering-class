package kr.ac.jejuuniv.twitter.controller;

import javax.servlet.http.HttpServletRequest;

import kr.ac.jejuuniv.twitter.service.FollowService;
import kr.ac.jejuuniv.twitter.service.TwitterService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
//전체 사용자 보기
public class AllUserController {

	@Autowired
	private FollowService followService;
	
	@RequestMapping("alluser")
	public ModelAndView goToMainWithAllUser(HttpServletRequest request){
		return new ModelAndView("main","pageType","/getalluser");
	}
	
	//전체 사용자 불러오기
	@RequestMapping("getalluser")
	public ModelAndView GetAllUser(HttpServletRequest request){
		String id = (String)request.getSession().getAttribute("loginID");
		ModelAndView alluserView = new ModelAndView();
		alluserView.setViewName("/twitt/alluser");
		alluserView.addObject("alluserlist",followService.getAllUserList(id));
		return alluserView;
	}
	
}
