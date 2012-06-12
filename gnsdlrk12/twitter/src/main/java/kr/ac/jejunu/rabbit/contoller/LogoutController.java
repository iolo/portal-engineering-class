package kr.ac.jejunu.rabbit.contoller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/logout")
public class LogoutController {
	
	@RequestMapping
	public String logoutAction(HttpServletRequest request, HttpServletResponse response){
		if(request.getSession() != null){
			request.getSession().setAttribute("loginId", null);
		}
		return "redirect:/";
	}
}
