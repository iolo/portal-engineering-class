package kr.ac.jejuuniv.controller;

import javax.servlet.http.HttpSession;

import kr.ac.jejuuniv.model.User;
import kr.ac.jejuuniv.service.UserService;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/sign")
public class SignController extends BaseFormController {
	
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
			return "redirect:/service/mainSns";
		} else {
			return "redirect:/";
		}
	}

}
