package kr.ac.jejuuniv.controller;

import javax.servlet.http.HttpServletRequest;

import kr.ac.jejuuniv.model.User;
import kr.ac.jejuuniv.service.LoginService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/login")
public class UserLogin {
	@Autowired
	private LoginService loginService;

	@RequestMapping
	public String action(@ModelAttribute User user, HttpServletRequest request, Model model) {
		boolean value = loginService.checkUser(user.getUserid(),
				user.getPassword());
		if (!value) {
			return "login";
		}
		request.getSession().setAttribute("loginId", user.getUserid());
		model.addAttribute("userId", user.getUserid());
		return "main";
	}
}
