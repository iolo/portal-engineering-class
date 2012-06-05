package kr.ac.jejuuniv.controller;

import kr.ac.jejuuniv.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/modify")
public class ModifyUserController {
	@Autowired
	private UserService userService;
	
	@RequestMapping
	public String action(@RequestParam String id, ModelMap map) {
		map.addAttribute(userService.getUser(id));
		return "modify";
	}
}
