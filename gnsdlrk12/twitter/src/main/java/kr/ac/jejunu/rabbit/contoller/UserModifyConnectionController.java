package kr.ac.jejunu.rabbit.contoller;

import javax.servlet.http.HttpSession;

import kr.ac.jejunu.rabbit.model.User;
import kr.ac.jejunu.rabbit.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/modify")
public class UserModifyConnectionController {
	@Autowired
	UserService userService;
	
	@RequestMapping
	public String userModify(Model model, HttpSession session){
		User user = userService.UserGet((String)session.getAttribute("loginId"));
		model.addAttribute("user", user);
		return "userModify";
	}
}
