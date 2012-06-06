package kr.ac.jejuuniv.twitter.controller;

import kr.ac.jejuuniv.twitter.model.UserModel;
import kr.ac.jejuuniv.twitter.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
//@RequestMapping("join.do")
public class JoinController {

	@Autowired
	private UserService userService;
	
	@RequestMapping("join.do")
	public String JoinUser(UserModel user){
		userService.addUser(user);
		return "redirect:/index";
	}
	
	@RequestMapping("joinform")
	public ModelAndView JoinForm(@ModelAttribute("join")UserModel user){
		return new ModelAndView("user/profile");
	}
}
