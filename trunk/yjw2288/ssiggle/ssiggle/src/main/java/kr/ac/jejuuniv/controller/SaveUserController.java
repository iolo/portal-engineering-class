package kr.ac.jejuuniv.controller;

import kr.ac.jejuuniv.model.User;
import kr.ac.jejuuniv.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/saveuser")
public class SaveUserController {
	@Autowired
	private UserService userService;

	@RequestMapping(method=RequestMethod.POST)
	public String action(@ModelAttribute User user) {
		userService.saveUser(user);
		return "redirect:/";
	}
}