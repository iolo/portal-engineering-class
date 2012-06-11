package kr.ac.jejuuniv.twitter.controller;

import javax.servlet.http.HttpServletRequest;

import kr.ac.jejuuniv.twitter.service.TwitterService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping
public class MyTwittController {
	
	@Autowired
	private TwitterService twitterService;
	
	@RequestMapping("getmytwitt.do")
	public ModelAndView goToMainWithMyTwittList(HttpServletRequest request){
		return new ModelAndView("main","pageType","/mytwitt");
	}
	
	@RequestMapping("mytwitt")
	public ModelAndView getMyTwitt(HttpServletRequest request){
		String id = (String)request.getSession().getAttribute("loginID");
		ModelAndView myTwittList = new ModelAndView();
		myTwittList.setViewName("/twitt/twittlist");
		myTwittList.addObject("title","나의 트윗");
		myTwittList.addObject("twittList",twitterService.getMyTwittList(id));
		return myTwittList;
	}

}
