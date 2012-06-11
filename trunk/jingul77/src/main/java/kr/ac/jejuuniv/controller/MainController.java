package kr.ac.jejuuniv.controller;

import kr.ac.jejuuniv.model.UserModel;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@RequestMapping("/main")
@SessionAttributes("user")
public class MainController {
	
	@RequestMapping()
	public void aaa(@ModelAttribute("user") UserModel user){
		
	}
	
}
