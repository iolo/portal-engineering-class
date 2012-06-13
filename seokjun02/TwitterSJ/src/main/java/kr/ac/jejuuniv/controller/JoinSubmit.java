package kr.ac.jejuuniv.controller;

import java.io.IOException;

import javax.servlet.http.HttpSession;

import kr.ac.jejuuniv.model.User;
import kr.ac.jejuuniv.service.LoginService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@Controller
@RequestMapping("/joinSubmit")
public class JoinSubmit {
	@Autowired
	private LoginService loginService;
	
	@RequestMapping(method = RequestMethod.POST)
	public String action(@ModelAttribute User user, @RequestParam(value = "profileImage", required = false) MultipartFile file, HttpSession session) throws IOException{
		if (file != null && !file.isEmpty()){
			loginService.saveImage(file, user);
		}
		
		loginService.saveUser(user);
		session.setAttribute("loginId", user.getUserId());
		
		return "redirect:/service/personal";
	}
}
