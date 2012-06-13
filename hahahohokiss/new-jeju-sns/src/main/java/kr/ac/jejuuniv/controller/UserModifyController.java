package kr.ac.jejuuniv.controller;

import kr.ac.jejuuniv.model.User;
import kr.ac.jejuuniv.service.UserService;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/service/update*")
public class UserModifyController extends BaseFormController {
	
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
