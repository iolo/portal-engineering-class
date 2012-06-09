package kr.ac.jejuuniv.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import kr.ac.jejuuniv.model.User;
import kr.ac.jejuuniv.service.UserService;

@Controller
@RequestMapping("/service/update*")
public class UserModifyController {
	@Autowired
	UserService userService;
	
	public UserModifyController(UserService userService) {
		this.userService = userService;
	}
	
	public UserModifyController() {
		
	}
	
	@RequestMapping
	public String userModifyAction(User user) {
		userService.modifyUser(user);
		return "redirect:/service/personalSns";
	}

}
