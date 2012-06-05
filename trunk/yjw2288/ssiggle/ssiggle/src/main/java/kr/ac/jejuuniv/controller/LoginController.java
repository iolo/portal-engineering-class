package kr.ac.jejuuniv.controller;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

import kr.ac.jejuuniv.model.User;
import kr.ac.jejuuniv.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/login")
public class LoginController {
	@Autowired
	private UserService userService;

	@RequestMapping(method = RequestMethod.POST)
	public String loginPage(@RequestParam String id,
			@RequestParam String password, HttpServletResponse response) {
		User user = userService.findUserById(id);
		if (!user.getPassword().equals(password)) {
			return "loginpage";
		}

		response.addCookie(new Cookie(ControllerConstant.LOGIN_COOKIE_NAME, id));
		return "redirect:/";
	}
}
