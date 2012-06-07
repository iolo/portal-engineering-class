package kr.ac.jejuuniv.controller;

import javax.servlet.http.HttpSession;

import kr.ac.jejuuniv.model.User;
import kr.ac.jejuuniv.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/sign")
public class SignController {
	
	@Autowired
	UserService userService;
	
	public SignController(UserService userService) {
		this.userService = userService;
	}
	
	public SignController() {
		
	}
	@RequestMapping
	public String singAction(String userId, String password, HttpSession session) {
		if(userService.getPassword(userId).equals(password)) {
			User loginUser = userService.getUser(userId);
			session.setAttribute("loginUser", loginUser);
			return "redirect:/service/test";
		} else {
			return "redirect:/";
		}
	}

}
