package kr.ac.jejuuniv.controller;

import kr.ac.jejuuniv.service.LoginService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/main")
public class SnsMain {
	@Autowired
	private LoginService loginService;
//	@RequestMapping
//	public List<User> action(Model model){
//		
//		return List<User>;
//		
//	}

}
