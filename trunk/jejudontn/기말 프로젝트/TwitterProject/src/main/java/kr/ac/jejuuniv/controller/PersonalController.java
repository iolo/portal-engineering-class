package kr.ac.jejuuniv.controller;

import java.util.List;

import kr.ac.jejuuniv.model.TwittList;
import kr.ac.jejuuniv.model.User;

import kr.ac.jejuuniv.service.TwittService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@RequestMapping("/personal")
@SessionAttributes("user")
public class PersonalController {
	
	@Autowired
	TwittService twittService;
	
	@RequestMapping()
	public List<TwittList> personal(@ModelAttribute("user") User user){
		
		return twittService.getPersonalTwiit(user.getId());
		
	}
	
	@RequestMapping(value="/remove", method = RequestMethod.GET)
	public String removeTwitt(@RequestParam("twittId") String twittId){
		twittService.removeTwitt(twittId);
		
		return "redirect:/personal";
	}

}
