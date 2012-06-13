package kr.ac.jejunu.rabbit.contoller;

import kr.ac.jejunu.rabbit.model.User;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/join")
public class UserJoinConnectionController {
	@RequestMapping
	public String userJoin(Model model){
		model.addAttribute("user", new User());
		return "memberJoin";
	}
}
