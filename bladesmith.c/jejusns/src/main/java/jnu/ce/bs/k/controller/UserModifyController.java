package jnu.ce.bs.k.controller;

import jnu.ce.bs.k.model.User;
import jnu.ce.bs.k.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.multipart.MultipartFile;

@Controller
@SessionAttributes("User")
@RequestMapping("/modify")
public class UserModifyController {

	@Autowired
	private UserService userService;

	@RequestMapping
	public String action() {
		return null;
	}

	
	@RequestMapping(method = RequestMethod.POST)
	public String postAction(@ModelAttribute("User") User user,
			@RequestParam("modifypassword") String password,
			@RequestParam("modifyname") String name,
			@RequestParam("modifydescription") String description,
			@RequestParam("modifyprofile") MultipartFile profile) {

		userService.modifyUser(name, password, description, profile, user);

		return "redirect:/myjeju.bs";
	}
}
