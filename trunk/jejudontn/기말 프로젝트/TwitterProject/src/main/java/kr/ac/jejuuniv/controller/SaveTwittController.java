package kr.ac.jejuuniv.controller;

import kr.ac.jejuuniv.model.User;
import kr.ac.jejuuniv.service.WriteService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@RequestMapping("/savetwitt")
@SessionAttributes("user")
public class SaveTwittController {
	
	@Autowired
	WriteService writeService;

	@RequestMapping(method = RequestMethod.POST)
	public void saveTwitt(@RequestParam("twitt") String twitt, @ModelAttribute("user") User user){

		writeService.createTwiit(user.getId(), twitt);
	}

}
