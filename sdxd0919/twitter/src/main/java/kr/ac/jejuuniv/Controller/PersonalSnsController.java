package kr.ac.jejuuniv.Controller;

import javax.servlet.http.HttpSession;

import kr.ac.jejuuniv.Model.User;
import kr.ac.jejuuniv.Repository.UserRepository;
import kr.ac.jejuuniv.Service.TweetService;
import kr.ac.jejuuniv.Service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class PersonalSnsController {

	@Autowired
	private TweetService tweetService;
	@Autowired
	private UserService userService;

	@RequestMapping("/personalSNS")
	public ModelAndView list(HttpSession session){
		int userNum = (Integer) session.getAttribute("userNum");
		User user = userService.getUser(userNum);
		
		ModelAndView mav = new ModelAndView();
		mav.setViewName("/personalSNS");
		mav.addObject("user", user);
		mav.addObject("tweetList", tweetService.getAllTweetByUserNum(userNum));
		
		return mav;
	}
	
	@RequestMapping("/deleteTweet")
	public String delete(int seq){
		tweetService.deleteTweet(seq);
		
		return "redirect:/personalSNS";
	}
}
