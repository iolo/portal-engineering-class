package kr.ac.jejuuniv.controller;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/logout")
public class LogoutController {
	@RequestMapping
	public String logoutAction(HttpServletRequest request,
			HttpServletResponse response) {
		Cookie[] cookies = request.getCookies();
		if (cookies != null) {
			for (Cookie c : cookies) {
				if (c.getName().equals(ControllerConstant.LOGIN_COOKIE_NAME)) {
					response.addCookie(new Cookie(
							ControllerConstant.LOGIN_COOKIE_NAME, null));
					c.setMaxAge(0);
				}
			}
		}

		return "redirect:/";
	}
}