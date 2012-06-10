package kr.ac.jejuuniv.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/signupform")
public class SignupFormController {
	
	@RequestMapping
	public String singupformAction() {
		return "signupform";
	}

}
