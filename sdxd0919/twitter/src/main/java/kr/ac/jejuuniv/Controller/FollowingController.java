package kr.ac.jejuuniv.Controller;

import javax.servlet.http.HttpSession;

import kr.ac.jejuuniv.Service.FollowService;
import kr.ac.jejuuniv.Service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class FollowingController {

	@Autowired
	private FollowService followService;
	@Autowired
	private UserService userSerivce;

	@RequestMapping("/service/followingList")
	public ModelAndView action(HttpSession session){
		int userNum = (Integer) session.getAttribute("userNum");
		
		ModelAndView mav = new ModelAndView();
		mav.addObject("user", userSerivce.getUser(userNum));
		mav.addObject("followingList", followService.getFollowingUserNum(userNum));
		mav.setViewName("/service/followingList");
		
		return mav;
	}
	
	@RequestMapping("/service/unfollow")
	public String unfollow(HttpSession session, @RequestParam("userNum") int followingUserNum,
							@RequestParam("url") String url){
		int userNum = (Integer) session.getAttribute("userNum");
		followService.unfollowUser(userNum, followingUserNum);
		
		return "redirect:" + url;
	}
	
}
