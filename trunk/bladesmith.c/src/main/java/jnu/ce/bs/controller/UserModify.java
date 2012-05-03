package jnu.ce.bs.controller;

import java.util.List;

import jnu.ce.bs.service.User;
import jnu.ce.bs.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/modify")
public class UserModify {
	
	@Autowired
	private UserService userService;
	
	@RequestMapping
	public User action (@RequestParam("id") String id){
		
		return userService.get(id);
	}
}
