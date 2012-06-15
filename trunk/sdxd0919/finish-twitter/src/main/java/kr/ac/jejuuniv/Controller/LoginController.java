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

	@RequestMapping(value="/login", method=RequestMethod.GET)
	public void login_get(){
	}
	
	@RequestMapping(value = "/login", method=RequestMethod.POST)
	public ModelAndView login_post(String id, String password, HttpSession session){
		ModelAndView mav = new ModelAndView();
		if(!(id.equals("")) && !(password.equals(""))){
			mav.setViewName("redirect:/service/SNS");
			
			User user = userService.checkUser(id, password);
			if(user != null){
				session.setAttribute("userNum", user.getUserNum());
				session.setAttribute("userId", id);
			}else{
				mav.addObject("/login");
			}
		}else{
			mav.addObject("/login");
		}
		
		return mav;
	}
	
	@RequestMapping("/logout")
	public String logout(HttpSession session){
		session.removeAttribute("userNum");
		session.removeAttribute("userId");
		session.invalidate();
		return "redirect:/login";
	}

}
