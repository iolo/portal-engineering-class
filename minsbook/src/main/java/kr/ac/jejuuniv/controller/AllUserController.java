package kr.ac.jejuuniv.controller;

import java.util.List;

import kr.ac.jejuuniv.model.User;
import kr.ac.jejuuniv.service.user.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@RequestMapping("/alluser")
@SessionAttributes("user")
public class AllUserController {
	
	@Autowired
	UserService userService;
	
	@RequestMapping()
	public List<User> allUsers(@ModelAttribute("user") User user){
		
		return userService.getList();
	}	
}
