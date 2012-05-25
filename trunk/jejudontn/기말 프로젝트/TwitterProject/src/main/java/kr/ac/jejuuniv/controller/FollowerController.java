package kr.ac.jejuuniv.controller;

import kr.ac.jejuuniv.model.User;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@RequestMapping("/follower")
@SessionAttributes("user")
public class FollowerController {
	
	@RequestMapping()
	public void follower(@ModelAttribute("user") User user){
		
	}

}
