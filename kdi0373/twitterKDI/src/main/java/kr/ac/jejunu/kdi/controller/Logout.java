package kr.ac.jejunu.kdi.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/logout")
public class Logout {

	@RequestMapping()
	public String logoutView(){
		return "redirect:/login";
				
	}
}
