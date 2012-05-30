package kr.ac.jejuuniv.controller;


import kr.ac.jejuuniv.model.User;
import kr.ac.jejuuniv.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@RequestMapping("changefollow")
@SessionAttributes("user")
public class followStatusController {
	
	@Autowired
	UserService userService;
	
	@RequestMapping(method = RequestMethod.GET)
	public String followuser(@ModelAttribute("user") User user, @RequestParam("follow") String follow, @RequestParam("followId") String followid) {
		userService.Followluser(user.getId() , follow, followid);
		
		return "redirect:/alluser";
		
	}
}
