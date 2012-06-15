package kr.ac.jejunu.rabbit.contoller;

import javax.servlet.http.HttpSession;

import kr.ac.jejunu.rabbit.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class MainController {
	
	@Autowired
	UserService userService;
	
	@RequestMapping
	public String action(HttpSession session, Model model) {
		String userid = (String)session.getAttribute("loginId");
		if (userid == null) {
			return "main";
		}
		
		model.addAttribute("user", userService.UserGet(userid));
		model.addAttribute("posts", userService.GetUserPost(userid));
		return "userpage";

	}
}
