package kr.ac.jejuuniv.controller;

import javax.servlet.http.HttpServletRequest;

import kr.ac.jejuuniv.model.UserModel;
import kr.ac.jejuuniv.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class JoinController {

	@Autowired
	private UserService userService;
	
	@RequestMapping("join")
	public ModelAndView tester(UserModel user){
		return new ModelAndView("join");
	}

	@RequestMapping("join.submit")
	public ModelAndView test(UserModel user){
		System.out.println(user.getComment());
		
		userService.insertUser(user);
		ModelAndView modelView = new ModelAndView("joinComple");
		modelView.addObject("id", user.getId());
		return modelView;
	}
	
	@RequestMapping("editProfile") 
	public ModelAndView editProfile(UserModel user, HttpServletRequest request) {
		
		ModelAndView modelView = new ModelAndView("modifyUser");
		modelView.addObject("User", userService.getUser((String)request.getSession().getAttribute("LoginId")));
		return modelView;
	}
	
	@RequestMapping("userModify")
	public ModelAndView userModify(UserModel user, HttpServletRequest request) {
		user.setId((String)request.getSession().getAttribute("LoginId"));
		
			userService.updateUser(user);

			
		
		ModelAndView modelView = new ModelAndView("redirect:Individual");
		return modelView;
		
	}
}
