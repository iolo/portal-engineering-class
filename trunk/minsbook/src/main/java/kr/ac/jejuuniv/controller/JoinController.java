package kr.ac.jejuuniv.controller;

import kr.ac.jejuuniv.model.User;
import kr.ac.jejuuniv.service.user.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;

@Controller
@RequestMapping("/join")
public class JoinController {

	@Autowired
	UserService userService;

	@RequestMapping(method = RequestMethod.GET)
	public String action(@ModelAttribute User user) {
		return "join";
	}

	@RequestMapping(method = RequestMethod.POST)
	public String saveUser(@ModelAttribute User user, MultipartFile profileImg) {
		userService.saveUser(user, profileImg);
		return "redirect:/login";
	}

}