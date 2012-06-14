package kr.ac.jejuuniv.controller;

import java.util.List;

import kr.ac.jejuuniv.model.User;
import kr.ac.jejuuniv.service.social.SocialNetworkService;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@RequestMapping("/follow")
@SessionAttributes("user")
public class FollowController {
	
	@Autowired
	SocialNetworkService socialNetworkService;
	
	@RequestMapping()
	public List<User> following(@ModelAttribute("User") User user){
		return socialNetworkService.getFollows(user.getId());
		
	}	
}
