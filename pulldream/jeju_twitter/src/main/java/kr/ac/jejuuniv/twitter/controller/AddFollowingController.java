package kr.ac.jejuuniv.twitter.controller;

import kr.ac.jejuuniv.twitter.service.TwitterService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("addfollowing.do")
public class AddFollowingController {
	@Autowired
	private TwitterService twitterService;
	
	@RequestMapping
	public void Test(){
//		twitterService.addFollowingById(id, following);
	}
}
