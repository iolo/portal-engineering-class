package kr.ac.jejuuniv.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import kr.ac.jejuuniv.model.User;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/service/followingList")
public class FollowingListController extends BaseFormController {
	
	@RequestMapping
	public ModelAndView action(HttpSession session) {
		ModelAndView modelAndView = new ModelAndView();
		User user = (User) session.getAttribute("loginUser");
		List<User> users = userService.getFollowingUser(user.getLoginId());
		
		modelAndView.addObject("users", users);
		modelAndView.setViewName("/service/followingList");
		return modelAndView;
	}
}
