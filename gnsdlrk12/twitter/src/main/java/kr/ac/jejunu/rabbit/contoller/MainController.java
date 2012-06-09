package kr.ac.jejunu.rabbit.contoller;

import javax.servlet.http.HttpSession;

import kr.ac.jejunu.rabbit.model.User;
import kr.ac.jejunu.rabbit.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/")
public class MainController {
	
	@Autowired
	UserService userService;
	
	@RequestMapping
	public String action(HttpSession session, Model model) {
		if (session.getAttribute("loginId") == null) {
			return "main";
		}

		return "redirect:/TweetAll";
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
