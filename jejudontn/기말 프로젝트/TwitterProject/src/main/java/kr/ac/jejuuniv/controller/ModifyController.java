package kr.ac.jejuuniv.controller;

import kr.ac.jejuuniv.model.User;
import kr.ac.jejuuniv.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.multipart.MultipartFile;

@Controller
@RequestMapping("/modify")
@SessionAttributes("user")
public class ModifyController {
	
	@Autowired
	UserService userService;

	@RequestMapping()
	public User modify(@ModelAttribute User user) {
		return user;
	}

	@RequestMapping(method = RequestMethod.POST)
	public String userModify(@ModelAttribute User user,
			@RequestParam("password") String password,
			@RequestParam("name") String name,
			@RequestParam("information") String information,
			@RequestParam("profileImage") MultipartFile profileImage) {
		String id = user.getId();
		userService.modifyUser(id,password, name, information, profileImage);
		
		
		return "redirect:/personal";
	}

}
