package kr.ac.jejunu.kdi.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/login")
//@SessionAttribute는  model을 위한 conversional data를 저장하는 것이 목적.
public class Login {
	
	
	@RequestMapping(method = RequestMethod.GET)
	public void loginView(){
		
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public String login(){
		
		return "redirect:/main";
	}

}
