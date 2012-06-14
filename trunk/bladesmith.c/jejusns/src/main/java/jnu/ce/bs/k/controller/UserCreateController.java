package jnu.ce.bs.k.controller;

import jnu.ce.bs.k.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@Controller
@RequestMapping("/create")
public class UserCreateController {

	@Autowired
	private UserService userService;

	@RequestMapping
	public String action() {
		return null;
	}

	@RequestMapping(method = RequestMethod.POST)
	public String action(@RequestParam("id") String id,
			@RequestParam("password") String password,
			@RequestParam("name") String name,
			@RequestParam("description") String description,
			@RequestParam("profile") MultipartFile profile) {

		userService.createUser(id, password, name, description, profile);
		
		return "redirect:/";
	}
}
