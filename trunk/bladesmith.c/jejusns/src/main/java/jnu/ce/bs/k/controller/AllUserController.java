package jnu.ce.bs.k.controller;

import java.util.List;

import jnu.ce.bs.k.model.User;
import jnu.ce.bs.k.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;


@Controller
@SessionAttributes("User")
@RequestMapping("/users.bs")
public class AllUserController {

	@Autowired
	private UserService userService;
	
	@RequestMapping
	public List<User> action(@ModelAttribute("User") User user){

		return userService.findFollowUserById(user);
	}
}
