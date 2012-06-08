package kr.ac.jejunu.rabbit.contoller;

import javax.servlet.http.HttpServletRequest;

import kr.ac.jejunu.rabbit.model.User;
import kr.ac.jejunu.rabbit.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class MainController {
	@Autowired
	private UserService userService;
	
	@RequestMapping
	public String action(@ModelAttribute User user, HttpServletRequest request, Model model) {
		boolean value = userService.Login(user);
		if (!value) {
			return "main";
		}
		request.getSession().setAttribute("loginId", user.getUserid());
		model.addAttribute("userId", user.getUserid());
		return "main";
	}
}
