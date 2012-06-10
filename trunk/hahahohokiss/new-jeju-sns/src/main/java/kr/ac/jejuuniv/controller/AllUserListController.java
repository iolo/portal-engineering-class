package kr.ac.jejuuniv.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import kr.ac.jejuuniv.model.User;
import kr.ac.jejuuniv.service.UserDto;
import kr.ac.jejuuniv.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/service/allUserList")
public class AllUserListController {
	
	@Autowired
	UserService userService;
	
	@RequestMapping
	public ModelAndView action(HttpSession session) {
		ModelAndView modelAndView = new ModelAndView();
		User user = (User) session.getAttribute("loginUser");
		
		List<UserDto> userDtos =userService.getAllUser(user.getLoginId());
		modelAndView.setViewName("/service/allUserList");
		modelAndView.addObject("userDtos", userDtos);
		
		return modelAndView;
		
	}
}
