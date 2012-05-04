package kr.ac.jejunu.kdi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping ("/modify");
public class UserModify {
	
	@Autowired
	private UserServie userService;
	
	
	public String userModify(String id , String name, String password){
		
		userService.userModify(id, name, password);
		return "redirect:/list";
	}
}
