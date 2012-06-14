package kr.ac.jejuuniv.controller;


import kr.ac.jejuuniv.service.user.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@Controller
@RequestMapping("/join")
public class JoinController {
		
	@Autowired
	UserService userService;
	
	@RequestMapping()
	public void action(){
		
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public String saveUser(@RequestParam("id") String id,
						   @RequestParam("password")String password, @RequestParam("name")String name, 
						   @RequestParam("nickname")String nickName, @RequestParam("profileImgPath") MultipartFile profileImgPath)
	{

		userService.saveUser(id, password, name, nickName, profileImgPath);
		
		return "redirect:/login";
	}
	
}
