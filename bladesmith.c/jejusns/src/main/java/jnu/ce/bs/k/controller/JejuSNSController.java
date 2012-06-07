package jnu.ce.bs.k.controller;

import jnu.ce.bs.k.model.User;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;


@Controller
@RequestMapping("/jeju.bs")
@SessionAttributes("User")
public class JejuSNSController {
	
	@RequestMapping()
	public void action(@ModelAttribute("User") User user){
		System.out.println(user.getId());
		
	}

}
