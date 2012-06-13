package kr.ac.jejuuniv.twitter.controller;

import javax.jws.HandlerChain;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.ac.jejuuniv.twitter.model.UserModel;
import kr.ac.jejuuniv.twitter.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("login.do")
public class LoginController{
	
	@Autowired
	private UserService userService;
	
	@RequestMapping
	public String Login(UserModel user,HttpServletRequest request){
		try {
			UserModel loginUser = userService.checkUser(user);
			if(loginUser.equals(null))	System.out.println("asdfasdf");
			else{
				request.getSession().setAttribute("loginID", loginUser.getId());
				request.getSession().setAttribute("loginName", loginUser.getName());
				return "redirect:/index";
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return "redirect:/";
		}
		return "redirect:/";
	}

}
