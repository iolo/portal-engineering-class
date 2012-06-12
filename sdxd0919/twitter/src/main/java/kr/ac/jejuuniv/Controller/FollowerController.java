package kr.ac.jejuuniv.Controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import kr.ac.jejuuniv.Service.FollowService;
import kr.ac.jejuuniv.Service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class FollowerController {
	@Autowired
	FollowService followService;
	@Autowired
	private UserService userSerivce;

	@RequestMapping("/service/followerList")
	public ModelAndView follwerList(HttpSession session){
		int userNum = (Integer) session.getAttribute("userNum");
		
		ModelAndView mav = new ModelAndView();
		mav.addObject("user", userSerivce.getUser(userNum));
		mav.addObject("followerList", followService.checkFollowerUsers(userNum));
		mav.setViewName("/service/followerList");
		
		return mav;
	}
	
	@RequestMapping("/service/follow")
	public String unfollow(HttpSession session, @RequestParam("userNum") int followingUserNum,
							@RequestParam("url") String url){
		int userNum = (Integer) session.getAttribute("userNum");
		followService.followUser(userNum, followingUserNum);
		
		return "redirect:" + url;
	}	
	
}
