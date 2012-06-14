package kr.ac.jejuuniv.controller;

import javax.servlet.http.HttpSession;

import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.stereotype.Controller;

@Controller
@RequestMapping("/logout")
public class UserLogoutController {
	@RequestMapping
	public String action(HttpSession session) {
		session.removeAttribute("loginId");
		return "redirect:/";
	}
}
