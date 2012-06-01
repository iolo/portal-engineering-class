package kr.ac.jejuuniv.controller;

import java.util.List;

import kr.ac.jejuuniv.model.TwittList;
import kr.ac.jejuuniv.model.User;
import kr.ac.jejuuniv.service.TwittService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@RequestMapping("/main")
@SessionAttributes("user")
public class MainController {
	@Autowired
	TwittService twittService;

	
	@RequestMapping
	public List<TwittList> main(@ModelAttribute("user") User user){
		return twittService.getFollowingTwitt(user.getId());
		
	}

}
