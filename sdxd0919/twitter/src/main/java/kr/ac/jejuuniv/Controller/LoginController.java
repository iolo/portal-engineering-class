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

	@RequestMapping("/login")
	public ModelAndView login(String id, String password, HttpSession session){
		if(id != null && password != null){
			ModelAndView mav = new ModelAndView();
			mav.setViewName("redirect:/personalSNS");
			
			User user = userService.checkUser(id, password);
			
			if(user != null){
				session.setAttribute("userNum", user.getUserNum());
				session.setAttribute("userId", id);
			}
			
			return mav;
		}else{
			return new ModelAndView("/login");
		}
	}
	
	
	@RequestMapping("/logout")
	public String logout(HttpSession session){
		session.removeAttribute("userNum");
		session.removeAttribute("userId");
		session.invalidate();
		return "redirect:/login";
	}
}
