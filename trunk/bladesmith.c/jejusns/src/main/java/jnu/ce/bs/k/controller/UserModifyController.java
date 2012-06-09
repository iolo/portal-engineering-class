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

	@RequestMapping(method=RequestMethod.POST)
	public String modify(@ModelAttribute("User") User user, @RequestParam("password") String password,
			@RequestParam("name") String name,
			@RequestParam("description") String description,
			@RequestParam("profile") String profile) {
		System.out.println("넌 왜 안타니?");
		user.setName(name);
		user.setPassword(password);
		user.setDescription(description);
		user.setProfile(profile);
		
		userService.modifyUser(user);
		return "redirect:/myjeju.bs";
	}
}
