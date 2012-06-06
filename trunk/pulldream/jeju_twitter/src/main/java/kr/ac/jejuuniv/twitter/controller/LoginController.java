package kr.ac.jejuuniv.twitter.controller;

import javax.servlet.http.HttpServletRequest;

import kr.ac.jejuuniv.twitter.model.UserModel;
import kr.ac.jejuuniv.twitter.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("login.do")
public class LoginController {
	
	@Autowired
	private UserService userService;
	
	@RequestMapping
	public ModelAndView Login(UserModel user,HttpServletRequest request){
		try {
			UserModel loginUser = userService.checkUser(user);
			
			if(loginUser.equals(null))	System.out.println("asdfasdf");
			else{
				request.getSession().setAttribute("loginId", loginUser.getId());
				return new ModelAndView("main","user",loginUser);
			}
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		return new ModelAndView("/");
	}
}
