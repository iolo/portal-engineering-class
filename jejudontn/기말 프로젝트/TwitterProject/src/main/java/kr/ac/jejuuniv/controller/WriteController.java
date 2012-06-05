package kr.ac.jejuuniv.controller;

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
@RequestMapping("/write")
@SessionAttributes("user")
public class WriteController {

	@Autowired
	TwittService twittService;

	@RequestMapping
	public void write() {

	}

	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public void saveTwitt(@RequestParam("twitt") String twitt,
			@ModelAttribute("user") User user) {

		twittService.createTwitt(user.getId(), twitt);
	}

}
