package kr.ac.jejuuniv.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/remove")
public class UserRemoveController {
	
	@RequestMapping
	public String remove(String id) {
		return "redirect/:list";
	}

}
