package kr.ac.jejuuniv.controller;

import kr.ac.jejuuniv.model.UserModel;
import kr.ac.jejuuniv.service.JoinService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.multipart.MultipartFile;

@Controller
@RequestMapping("/update")
@SessionAttributes("user")
public class UpdateController {
	
	@Autowired
	JoinService joinService;

	@RequestMapping()
	public UserModel update(@ModelAttribute UserModel user){
		return user;
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public String updateUser(@ModelAttribute("user") UserModel user,
						   @RequestParam("password")String password, @RequestParam("name")String name, 
						   @RequestParam("explain")String explain, @RequestParam("profileImage")MultipartFile image)
	{	
		String id=user.getId();
		joinService.UpdateUser(id, password, name, explain, image);
		
		return "redirect:/personal";
	}	
}
