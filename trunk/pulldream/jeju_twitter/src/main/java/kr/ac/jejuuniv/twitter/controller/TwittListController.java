package kr.ac.jejuuniv.twitter.controller;

import javax.servlet.http.HttpServletRequest;

import kr.ac.jejuuniv.twitter.service.TwitterService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

//트윗된 리스트 보여주기
@Controller
public class TwittListController {
	
	@Autowired
	private TwitterService twitterService;
	
	@RequestMapping("twittlist")
	public ModelAndView TwittList(HttpServletRequest request){
		String id = (String) request.getSession().getAttribute("loginID");
		return new ModelAndView("twitt/twittlist","twittList",twitterService.getTwittList(id));
	}
}
