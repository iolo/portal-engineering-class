package kr.ac.jejuuniv.controller;

import java.util.List;

import kr.ac.jejuuniv.model.User;
import kr.ac.jejuuniv.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@RequestMapping("/list")
@SessionAttributes("user")
public class UserList {
	@Autowired
	private UserService userService;
	@RequestMapping
	public List<User> action(Model model, User user2) {
		User user = userService.get("1");
		System.out.println(user2.getId());
		model.addAttribute("user", user);
		return userService.list();
	}
}
