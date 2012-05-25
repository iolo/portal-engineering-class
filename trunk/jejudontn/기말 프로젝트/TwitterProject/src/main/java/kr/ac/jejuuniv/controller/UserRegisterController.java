package kr.ac.jejuuniv.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@Controller
@RequestMapping("/register")
public class UserRegisterController {

	@RequestMapping(method = RequestMethod.POST)
	public String userRegister(@RequestParam("id") String id,
			@RequestParam("password") String password,
			@RequestParam("name") String name,
			@RequestParam("information") String infromation,
			@RequestParam("profileImage") MultipartFile profileImage) {
		
		return "redirect:/index";
		
	}

}
