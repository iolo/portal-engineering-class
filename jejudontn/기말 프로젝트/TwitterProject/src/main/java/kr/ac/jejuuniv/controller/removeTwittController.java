package kr.ac.jejuuniv.controller;

import kr.ac.jejuuniv.service.TwittService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@RequestMapping("/removetwitt")
@SessionAttributes("user")
public class removeTwittController {
	
	@Autowired
	TwittService twittService;
	
	@RequestMapping(method = RequestMethod.GET)
	public String removeTwitt(@RequestParam("twittId") String twittId){
		twittService.removeTwitt(twittId);
		
		return "redirect:/personal";
	}

}
