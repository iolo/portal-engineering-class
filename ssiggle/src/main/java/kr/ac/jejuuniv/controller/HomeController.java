package kr.ac.jejuuniv.controller;

import kr.ac.jejuuniv.model.user.User;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class HomeController {
	@RequestMapping
	public String action(
			@CookieValue(value = "loginId", required = false) String loginId,
			ModelMap model) {
		if (loginId == null || loginId.equals("")) {
			return "login";
		}

		User user = new User().findUserById(loginId);

		model.addAttribute("user", user);
		return "main";
	}
}