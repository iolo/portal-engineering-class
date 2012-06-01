package kr.ac.jejuuniv.controller;

import kr.ac.jejuuniv.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@Controller
@RequestMapping("/create")
public class CreateController {
	
	@RequestMapping()
	public void createUser(){
		
	}
	@Autowired
	UserService userService;
	
	@RequestMapping(value="/register", method = RequestMethod.POST)
	public String userRegister(@RequestParam("id") String id,
			@RequestParam("password") String password,
			@RequestParam("name") String name,
			@RequestParam("information") String information,
			@RequestParam("profileImage") MultipartFile profileImage) {
		
		userService.createUser(id, password, name, information, profileImage);
		
		return "redirect:/index";

	}

}
