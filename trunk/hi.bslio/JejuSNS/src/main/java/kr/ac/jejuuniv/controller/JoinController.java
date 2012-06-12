package kr.ac.jejuuniv.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import kr.ac.jejuuniv.model.UserModel;
import kr.ac.jejuuniv.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class JoinController {

	@Autowired
	private UserService userService;
	
	@RequestMapping("join")
	public ModelAndView tester(UserModel user){
		return new ModelAndView("join");
	}

	@RequestMapping(value="join.submit",  method=RequestMethod.POST)
	public ModelAndView test(UserModel user, @RequestParam("file") MultipartFile file, HttpServletRequest request) throws IOException{
		System.out.println(user.getComment());
				
		ModelAndView modelView = new ModelAndView("joinComple");
		
		if(!file.isEmpty()) {
			byte[] byteFile = file.getBytes();
			File uploadedFile = new File(request.getSession().getServletContext().getRealPath("/") + "images/userprofile/" + user.getId());
			FileOutputStream fos;
			fos = new FileOutputStream(uploadedFile);
			fos.write(byteFile);
			fos.close();

			user.setImage(user.getId());
		}else{
			user.setImage("default");
		}
		
		userService.insertUser(user);
		
		modelView.addObject("user", user);
		return modelView;
	}
	
	@RequestMapping("editProfile") 
	public ModelAndView editProfile(UserModel user, HttpServletRequest request) {
		
		ModelAndView modelView = new ModelAndView("modifyUser");
		modelView.addObject("User", userService.getUser((String)request.getSession().getAttribute("LoginId")));
		return modelView;
	}
	
	@RequestMapping(value="userModify",  method=RequestMethod.POST)
	public ModelAndView userModify(UserModel user, @RequestParam("file") MultipartFile file, HttpServletRequest request) throws IOException {
		user.setId((String)request.getSession().getAttribute("LoginId"));
		
		if(!file.isEmpty()) {
			byte[] byteFile = file.getBytes();
			File uploadedFile = new File(request.getSession().getServletContext().getRealPath("/") + "images/userprofile/" + user.getId());
			FileOutputStream fos;
			fos = new FileOutputStream(uploadedFile);
			fos.write(byteFile);
			fos.close();

			user.setImage(user.getId());
		}
		
			userService.updateUser(user);

			
		
		ModelAndView modelView = new ModelAndView("redirect:Individual");
		return modelView;
		
	}
}
