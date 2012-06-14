package kr.ac.jejuuniv.twitter.controller;

import javax.servlet.http.HttpServletRequest;

import kr.ac.jejuuniv.twitter.service.TwitterService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class AllUserController {

	@Autowired
	private TwitterService twitterService;
	
	@RequestMapping("getallusers.do")
	public ModelAndView goToMainWithAllUser(HttpServletRequest request){
		return new ModelAndView("main","pageType","/getalluser");
	}
	
	@RequestMapping("getalluser")
	public ModelAndView GetAllUser(HttpServletRequest request){
		String id = (String)request.getSession().getAttribute("loginID");
		ModelAndView alluserView = new ModelAndView();
		alluserView.setViewName("/twitt/alluser");
		alluserView.addObject("alluserlist",twitterService.getAllUserList(id));
		return alluserView;
	}
	
}
