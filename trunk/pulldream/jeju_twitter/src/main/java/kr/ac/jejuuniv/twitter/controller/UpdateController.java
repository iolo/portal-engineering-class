package kr.ac.jejuuniv.twitter.controller;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.nio.channels.FileChannel;

import javax.servlet.http.HttpServletRequest;

import kr.ac.jejuuniv.twitter.model.UserModel;
import kr.ac.jejuuniv.twitter.repository.UserRepository;
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
public class UpdateController {

	@Autowired
	private UserService userService;
	
	@Autowired
	private UserRepository userRepository;
	
	@RequestMapping("update.do")
	public String JoinUser(@ModelAttribute("join")UserModel user, @RequestParam("file")MultipartFile file)throws IOException{
		byte[] byteFile = file.getBytes();
		File uploadedFile = new File("/Volumes/Data/Mac Data/Documents/Develope/Lecture/jeju_twitter/src/main/webapp/resources/profile/"+user.getId());

		FileInputStream fis = null;
		FileOutputStream fos = null;
		FileChannel in = null;
		FileChannel out = null;
		
		fos = new FileOutputStream(uploadedFile);
		
		//이미지를 업로드를 할 경우 아이디에 맞게 이미지 전송
		//이미지를 업로드 하지 않을 경우 디폴트 이미지 링크

		try {
		if(!user.isPath()){
				if(file.isEmpty()){
					user.setPath(false);
					File default_img = new File("/Volumes/Data/Mac Data/Documents/Develope/Lecture/jeju_twitter/src/main/webapp/resources/profile/default_img.png");
					
					fis = new FileInputStream(default_img);
					in = fis.getChannel();
					out = fos.getChannel();
					
					in.transferTo(0, in.size(), out);
					
				}else{
					user.setPath(true);
					fos.write(byteFile);
				}
			}
		}
		catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally{
			fos.close();
			fis.close();
			out.close();
			in.close();
		}
		userRepository.updateUser(user);
		return "redirect:/index";
	}
	
	@RequestMapping("updateform")
	public ModelAndView JoinForm(@ModelAttribute("join")UserModel user, HttpServletRequest request)throws IOException{
		String id = (String)request.getSession().getAttribute("loginID");
		user=userRepository.findUserById(id);
		System.out.println(user.getProfile());
		return new ModelAndView("user/updateuser","user",user);
	}
}
