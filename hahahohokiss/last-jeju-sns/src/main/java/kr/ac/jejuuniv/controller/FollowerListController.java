package kr.ac.jejuuniv.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import kr.ac.jejuuniv.model.User;
import kr.ac.jejuuniv.service.UserDto;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/service/followerList")
public class FollowerListController extends BaseFormController {

	
	@RequestMapping
	public ModelAndView action(HttpSession session) {
		ModelAndView modelAndView = new ModelAndView();
		User user = (User) session.getAttribute("loginUser");
		List<UserDto> userDtos = userService.getFollowerUser(user.getLoginId());
		
		modelAndView.addObject("userDtos", userDtos);
		modelAndView.setViewName("/service/followerList");
		return modelAndView;
	}
}
