package kr.ac.jejuuniv.controller;

import javax.servlet.http.HttpServletResponse;

import kr.ac.jejuuniv.model.user.User;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/loginProcess")
public class LoginProcessController {
	@RequestMapping(method = RequestMethod.POST)
	public String loginPage(@RequestParam String id,
			@RequestParam String password, HttpServletResponse response) {
		if (!(new User().loginValid(id, password))) {
			return "redirect:/login";
		}

		return LoginControllUtil.saveCookie4Login(id, response);
	}
}