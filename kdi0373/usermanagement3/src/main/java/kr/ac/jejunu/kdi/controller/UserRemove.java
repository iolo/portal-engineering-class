package kr.ac.jejunu.kdi.controller;

import kr.ac.jejunu.kdi.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/remove")
public class UserRemove {
	
	@Autowired
	private UserService userService;
	
	@RequestMapping
	public String delete(String id){
		
		userService.deleteUserList(id);
		
		return "redirect:/list";
	}

}
