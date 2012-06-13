package kr.ac.jejuuniv.controller;

import java.io.IOException;

import kr.ac.jejuuniv.model.User;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@Controller
@RequestMapping("/signup")
public class SingupController extends BaseFormController {
	
	@RequestMapping
	public String test(User user, @RequestParam("file") MultipartFile file) throws IOException {
		userService.addUser(user, file);
		return "redirect:/";
	}
	

}
