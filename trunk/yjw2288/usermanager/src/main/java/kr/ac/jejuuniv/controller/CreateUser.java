package kr.ac.jejuuniv.controller;

import kr.ac.jejuuniv.model.User;
import kr.ac.jejuuniv.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/save")
public class CreateUser {
	@Autowired
	private UserService service;

	public String action(@RequestParam("id") String id,
			@RequestParam("name") String name,
			@RequestParam("password") String password, ModelMap model) {
		User user = new User(id, name, password);
		service.add(user);

		return "list";
	}
}
