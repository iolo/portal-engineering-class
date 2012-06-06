package kr.ac.jejuuniv.controller;

import kr.ac.jejuuniv.model.UserModel;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("login.do")
public class AuthController {
	@RequestMapping
	public ModelAndView Login(UserModel user) {
		System.out.println("아아아아아");
		return null;
	}
}
