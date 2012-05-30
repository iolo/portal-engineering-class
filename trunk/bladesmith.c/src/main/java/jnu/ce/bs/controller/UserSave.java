package jnu.ce.bs.controller;

import jnu.ce.bs.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/save")
public class UserSave {

	@Autowired
	private UserService userService;

	@RequestMapping(method = RequestMethod.POST)
	public String action(@RequestParam("id") String id,
			@RequestParam("name") String name,
			@RequestParam("password") String password) {
		
		userService.add(id, name, password);

		return "redirect:/list";
	}
}