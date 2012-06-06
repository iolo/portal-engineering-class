package kr.ac.jejuuniv.Controller;

import javax.servlet.http.HttpSession;

import kr.ac.jejuuniv.Model.User;
import kr.ac.jejuuniv.Service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class LoginController {
	
	@Autowired
	private UserService userService;

	@RequestMapping(value="/", method=RequestMethod.GET)
	public String home() {
		return "/login";
	}

	
	@RequestMapping("/login")
	public ModelAndView login(String id, String password, HttpSession session){
		ModelAndView mav = new ModelAndView();
		mav.setViewName("redirect:/personalSNS");

		User user = userService.checkUser(id, password);
		
		if(user != null){
			session.setAttribute("user", user);
		}
		
		return mav;
	}
	
	
	@RequestMapping("/logout")
	public String logout(HttpSession session){
		session.setAttribute("user", null);
		session.invalidate();
		return "/login";
	}
}
