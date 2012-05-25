package kr.ac.jejuuniv.controller;

import kr.ac.jejuuniv.service.LoginService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@RequestMapping("/login")
@SessionAttributes("userid")
public class LoginController {
	
	@Autowired
	LoginService loginService;
	
	@RequestMapping(method = RequestMethod.POST)
	public String login(@RequestParam("id") String id, @RequestParam("password") String password) {
		//loginService.loginDecision(id,password);
		//로그인 아이디가 있을경우
		return "redirect:/main";
		//로그인 아이디가 없을경우 다시 원래 페이지로
	}

}
