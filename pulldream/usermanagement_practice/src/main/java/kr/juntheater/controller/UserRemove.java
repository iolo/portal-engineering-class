package kr.juntheater.controller;

import kr.juntheater.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/remove")
public class UserRemove {
	@Autowired
	private UserService userService;
	
	@RequestMapping
	public String remove(String id){
		System.out.println(id+"remvoe");
		userService.remove(id);
		return "redirect:/list";
	}
}
