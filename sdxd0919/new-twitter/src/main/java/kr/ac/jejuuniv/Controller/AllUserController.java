package kr.ac.jejuuniv.Controller;

import javax.servlet.http.HttpSession;

import kr.ac.jejuuniv.Service.FollowService;
import kr.ac.jejuuniv.Service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class AllUserController {
	
	@Autowired
	FollowService followService;
	@Autowired
	private UserService userSerivce;

	@RequestMapping("/service/allUserList")
	public ModelAndView allUser(HttpSession session){
		int userNum = (Integer) session.getAttribute("userNum");
		
		ModelAndView mav = new ModelAndView();
		mav.addObject("user", userSerivce.getUserByUserNum(userNum));
		mav.addObject("allUserList", followService.checkAllUsers(userNum));
		mav.setViewName("/service/allUserList");
		
		return mav;
	}
}
