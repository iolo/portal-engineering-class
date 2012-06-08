package kr.ac.jejuuniv.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import kr.ac.jejuuniv.model.User;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class Index {
	@RequestMapping
	public String action(HttpSession session, Model model) {
//		HttpSession session = request.getSession();
		
		if (session.getAttribute("loginId") == null) {
			model.addAttribute("user", new User());
			return "login";
		}

		model.addAttribute("userId", session.getAttribute("loginId"));
		return "main";
	}
}
