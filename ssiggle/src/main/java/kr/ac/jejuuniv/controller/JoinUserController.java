package kr.ac.jejuuniv.controller;

import kr.ac.jejuuniv.model.user.User;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/joinUser")
public class JoinUserController {
	@RequestMapping
	public String action(ModelMap model) {
		model.addAttribute("user", new User());
		return "joinUser";
	}
}
