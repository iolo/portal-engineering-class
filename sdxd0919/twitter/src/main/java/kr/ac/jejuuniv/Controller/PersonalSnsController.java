package kr.ac.jejuuniv.Controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import kr.ac.jejuuniv.Model.User;
import kr.ac.jejuuniv.Service.TweetService;
import kr.ac.jejuuniv.Service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/personalSNS")
public class PersonalSnsController {

	@Autowired
	private UserService userService;
	
	@Autowired
	private TweetService tweetService;

	@RequestMapping
	public ModelAndView action(HttpSession session, HttpServletRequest request){
		User user = (User) session.getAttribute("user");
		
		ModelAndView mav = new ModelAndView();
		mav.setViewName("/personalSNS");
		
		int userNum = user.getUserNum();
		mav.addObject("tweetList", tweetService.getAllTweetByUserNum(userNum));
		
		return mav;
	}
}
