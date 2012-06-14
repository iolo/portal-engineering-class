package kr.ac.jejuuniv.controller;

import javax.servlet.http.HttpSession;

import kr.ac.jejuuniv.model.User;
import kr.ac.jejuuniv.service.LoginService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/service/modifyuser")
public class ModifyUserController {
	@Autowired
	private LoginService loginService;
	
	@RequestMapping(method = RequestMethod.GET)
	public String action(HttpSession session, Model model){
		String userId = (String)session.getAttribute("loginId");
		User user = loginService.findUserById(userId);
		user.setPassword("");
		
		model.addAttribute("user", user);
		return "modifyuser";
	}

}
