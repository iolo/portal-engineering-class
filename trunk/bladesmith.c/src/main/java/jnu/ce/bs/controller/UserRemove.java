package jnu.ce.bs.controller;

import jnu.ce.bs.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/remove")
public class UserRemove {

	@Autowired
	private UserService userService;
	
	@RequestMapping
	public String action (@RequestParam("id") String id){
		userService.delete(id);
		
		return "redirect:/list";
	}
}

