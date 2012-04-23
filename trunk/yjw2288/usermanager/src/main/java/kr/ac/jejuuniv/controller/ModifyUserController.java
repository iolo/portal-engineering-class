package kr.ac.jejuuniv.controller;

import kr.ac.jejuuniv.model.User;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/modify")
public class ModifyUserController {
	@RequestMapping
	public String action(ModelMap map) {
		map.addAttribute(new User());
		return "list";
	}
}
