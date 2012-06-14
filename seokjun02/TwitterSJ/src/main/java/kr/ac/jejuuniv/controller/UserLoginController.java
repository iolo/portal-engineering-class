package kr.ac.jejuuniv.controller;

import javax.servlet.http.HttpSession;

import kr.ac.jejuuniv.model.User;
import kr.ac.jejuuniv.service.LoginService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/login")
public class UserLoginController {
	@Autowired
	private LoginService loginService;

	@RequestMapping
	public String action(@ModelAttribute User user, HttpSession session, Model model) {
		boolean value = loginService.checkUser(user.getUserId(), user.getPassword());
		if (!value) {
			return "redirect:/";
		}
		session.setAttribute("loginId", user.getUserId());
		model.addAttribute("userId", user.getUserId());
		return "redirect:/service/personal";
	}
}
