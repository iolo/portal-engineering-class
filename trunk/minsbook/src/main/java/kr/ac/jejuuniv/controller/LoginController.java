package kr.ac.jejuuniv.controller;

import kr.ac.jejuuniv.service.user.UserService;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@RequestMapping("/login")
@SessionAttributes("user")
public class LoginController {
	
	@Autowired
	UserService userService;

	@RequestMapping(method = RequestMethod.GET, value = "/login")
	public void login(){
		
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public String login(@RequestParam("id") String id, @RequestParam("password") String password, Model model)
	{
		
		if (userService.loginCheck(id, password, model)) {
			return "redirect:/main";
		} else {
			return "redirect:/login";
		}
	}	
}
