package kr.ac.jejuuniv.twitter.controller;

import kr.ac.jejuuniv.twitter.model.TwittModel;
import kr.ac.jejuuniv.twitter.service.TwitterService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("deletetwitt.do")
public class DeleteMyTwittController {
	
	@Autowired
	private TwitterService twitterService;
	
	//자신의 트위터 삭제
	@RequestMapping
	public String deteMyTwitt(TwittModel twittModel){
		twitterService.deleteMyTwitt(twittModel.getTwinum());
		return "redirect:/getmytwitt.do";
	}
}
