package kr.ac.jejuuniv.controller;

import kr.ac.jejuuniv.model.User;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/joinmember")
public class JoinMember {
	@RequestMapping
	public String action(Model model){
		model.addAttribute("user", new User());
		return "joinmember";
	}

}
