package kr.ac.jejunu.kdi.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class Start {
	
	@RequestMapping()
	public String startView(){
		return "redirect:/login";
	}

}
