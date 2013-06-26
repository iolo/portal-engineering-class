package com.rillflow.memo;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.rillflow.memo.model.User;
import com.rillflow.memo.service.UserService;

@Controller
public class UserController {
	
	@Autowired
	UserService userService;

	@RequestMapping(value = "/user/join")
	public String join(Model model, HttpServletRequest request) {
		return "user/join";
	}
	
	@RequestMapping(value = "/user/joinProcess")
	public String joinProcess(User user, HttpServletRequest request) {
		userService.join(user);
		
		return "redirect:/";
	}
	
	@RequestMapping(value = "/login")
	public String login(Model model, HttpServletRequest request) {		
		return "user/login";
	}

	@RequestMapping(value = "/loginProcess")
	public String loginProcess(User user, HttpSession session, HttpServletRequest request) {
		User result = userService.login(user.getId(), user.getPassword());

		if (result != null) {
			session.setAttribute("user", result);
		}
		
		return "redirect:/";
	}

	@RequestMapping(value = "/logout")
	public String logout(HttpSession session) {
		session.setAttribute("user", null);
		
		return "redirect:/";
	}

	@RequestMapping(value = "/user/modify")
	public String modify(Model model, HttpServletRequest request, HttpSession session) {
		User user = (User) session.getAttribute("user");
		
		model.addAttribute("user", user);
		
		return "user/join";
	}

	@RequestMapping(value = "/user/modifyProcess")
	public String modifyProcess(User user, HttpServletRequest request, HttpSession session) {
		userService.modify(user);
		session.setAttribute("user", user);
		
		return "redirect:/";
	}
}
