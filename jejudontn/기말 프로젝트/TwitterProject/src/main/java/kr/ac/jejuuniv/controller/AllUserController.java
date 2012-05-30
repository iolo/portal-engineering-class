package kr.ac.jejuuniv.controller;

import java.util.List;

import kr.ac.jejuuniv.model.AllUsers;
import kr.ac.jejuuniv.model.User;
import kr.ac.jejuuniv.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@RequestMapping("/alluser")
@SessionAttributes("user")
public class AllUserController {
	List<AllUsers> users;
	@Autowired
	UserService userService;
	
	@RequestMapping()
	public List<AllUsers> findalluser(@ModelAttribute("user") User user){
		 
	
		return userService.findAlluser(user.getId());
	}
	
	
	

}
