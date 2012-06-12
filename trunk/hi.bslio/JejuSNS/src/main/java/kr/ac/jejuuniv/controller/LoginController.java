package kr.ac.jejuuniv.controller;

import javax.servlet.http.HttpServletRequest;

import kr.ac.jejuuniv.model.UserModel;
import kr.ac.jejuuniv.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class LoginController {
	@Autowired
	UserService userService;
		
	@RequestMapping("/")
	public ModelAndView index() {
		return new ModelAndView("redirect:public_page");
	}
	
	@RequestMapping("login_page")
	public ModelAndView login_page() {
		return new ModelAndView("login_page");
	}
	
	@RequestMapping("logout")
	public ModelAndView logout(HttpServletRequest request) {
		request.getSession().removeAttribute("LoginId");
		return new ModelAndView("redirect:login_page");
	}
	
	@RequestMapping("login.do")
	public ModelAndView Login(UserModel user, HttpServletRequest request) {
		UserModel authUser = userService.getUser(user.getId());
		if(authUser != null) {
			if(authUser.getPassword().equals(user.getPassword())) {
				request.getSession().setAttribute("LoginId", user.getId());
				
				ModelAndView mav = new ModelAndView("redirect:public_page");
				
				return mav;
				
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
