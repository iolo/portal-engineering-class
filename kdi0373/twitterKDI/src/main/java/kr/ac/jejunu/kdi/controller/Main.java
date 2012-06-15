package kr.ac.jejunu.kdi.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@RequestMapping("/main")
@SessionAttributes("user")
public class Main {
	
	@RequestMapping()
	public void mainView(){
		
	}

}
