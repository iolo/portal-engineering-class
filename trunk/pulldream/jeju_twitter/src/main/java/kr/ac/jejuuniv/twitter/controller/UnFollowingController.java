package kr.ac.jejuuniv.twitter.controller;

import javax.servlet.http.HttpServletRequest;

import kr.ac.jejuuniv.twitter.model.FollowingModel;
import kr.ac.jejuuniv.twitter.service.TwitterService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("unfollow.do/{pageType}")
public class UnFollowingController {
	
	@Autowired
	private TwitterService twitterService;
	
	@RequestMapping
	public String UnFollowing(@ModelAttribute("following")FollowingModel followModel,HttpServletRequest request){
		String id = (String)request.getSession().getAttribute("loginID");
		twitterService.unFollowingById(id, followModel.getFollowing());
//		return new ModelAndView("/getfollowing.do");

		if(request.getRequestURI().endsWith("following")){
			return "redirect:/getfollowing.do";
		}
		else
			return "redirect:/getfollower.do";
	}

}
