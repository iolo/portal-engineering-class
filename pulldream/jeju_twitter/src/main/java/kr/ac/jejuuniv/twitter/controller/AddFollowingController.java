package kr.ac.jejuuniv.twitter.controller;

import javax.servlet.http.HttpServletRequest;

import kr.ac.jejuuniv.twitter.model.FollowingModel;
import kr.ac.jejuuniv.twitter.service.TwitterService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("following.do/{pageType}")
public class AddFollowingController {
	
	@Autowired
	private TwitterService twitterService;
	
	@RequestMapping
	public String Following(@PathVariable("pageType")String pageType, @ModelAttribute("following")FollowingModel followModel,HttpServletRequest request){
		String id = (String)request.getSession().getAttribute("loginID");
		twitterService.addFollowingById(id, followModel.getFollowing());
		System.out.println(pageType);
		return "redirect:/"+pageType;
	}

}
