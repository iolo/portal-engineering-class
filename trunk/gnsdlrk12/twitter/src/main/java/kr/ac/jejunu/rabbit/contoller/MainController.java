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
	
//	@RequestMapping(method = RequestMethod.POST)
//	public String login(@RequestParam("userid") String userid,
//			@RequestParam("password") String password, Model model) {
//
//		if (userService.Login(userid, password)) {
//			model.addAttribute("user", userService.UserGet(userid));
//			return "redirect:/userpage";
//		} else {
//			return "redirect:/main";
//		}
//	}
}
