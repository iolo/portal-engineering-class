package kr.ac.jejuuniv.Controller;

import javax.servlet.http.HttpSession;
import kr.ac.jejuuniv.Service.TweetService;
import kr.ac.jejuuniv.Service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/service/SNS")
public class SnsController {

	@Autowired
	TweetService tweetService;
	@Autowired
	UserService userService;
	
	@RequestMapping
	public ModelAndView action(HttpSession session){
		int userNum = (Integer) session.getAttribute("userNum");
		System.out.println("controller    userNum = " + userNum);
		
		ModelAndView mav = new ModelAndView();
		mav.addObject("user", userService.getUser(userNum));
		mav.addObject("UserTweets", tweetService.getUserTweet(userNum));
		mav.setViewName("/service/SNS");
		
		return mav;
	}
}
