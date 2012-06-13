package kr.ac.jejuuniv.twitter.controller;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

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
		
		//이미지를 업로드를 할 경우 아이디에 맞게 이미지 전송
		//이미지를 업로드 하지 않을 경우 디폴트 이미지 링크
		if(byteFile.length==0){
//			file.transferTo("Users/JunTheater/Document/Develope/Lecture/jeju_twitter/src/main/webapp/resources/profile/a.jpg");
			user.setPath(false);
		}
		else	user.setPath(true);
		
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
