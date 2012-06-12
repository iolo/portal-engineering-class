package kr.ac.jejuuniv.controller;

import javax.servlet.http.HttpServletRequest;

import kr.ac.jejuuniv.model.UserModel;
import kr.ac.jejuuniv.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class AuthController {
	@Autowired
	UserService userService;
	
	@RequestMapping("fileuppage")
	public ModelAndView fileuppage() {
		
		return new ModelAndView("fileupload");
	}
	
	@RequestMapping("login.do")
	public ModelAndView Login(UserModel user, HttpServletRequest request) {
		UserModel authUser = userService.getUser(user.getId());
		if(authUser != null) {
			if(authUser.getPassword().equals(user.getPassword())) {
				request.getSession().setAttribute("LoginId", user.getId());
				
				ModelAndView modelAndView = new ModelAndView("redirect:publicPage");
				
				return modelAndView;
				
			}else{
				// 로그인 실패 (패스워드 불일치)
				return null;
			}
			
		}else {
			// 로그인 실패(아이디 없음?)
			return null;
		}
	}
}
