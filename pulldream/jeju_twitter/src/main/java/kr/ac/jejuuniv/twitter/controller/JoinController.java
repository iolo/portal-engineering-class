package kr.ac.jejuuniv.twitter.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import kr.ac.jejuuniv.twitter.model.UserModel;
import kr.ac.jejuuniv.twitter.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

@Controller
//@RequestMapping("join.do")
public class JoinController {

	@Autowired
	private UserService userService;
	
	@RequestMapping("join.do")
	public String JoinUser(UserModel user, @RequestParam("file")MultipartFile file)throws IOException{
		byte[] byteFile = file.getBytes();
		File uploadedFile = new File("/Users/JunTheater/Documents/"+user.getId());
		FileOutputStream fos;
		fos = new FileOutputStream(uploadedFile);
		fos.write(byteFile);
		fos.close();
		
		userService.addUser(user);
		return "redirect:/index";
	}
	
	@RequestMapping("joinform")
	public ModelAndView JoinForm(@ModelAttribute("join")UserModel user){
		return new ModelAndView("user/profile");
	}
}
