package kr.ac.jejunu.rabbit.contoller;

import kr.ac.jejunu.rabbit.model.User;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/join")
public class MemberJoinController {
	@RequestMapping
	public String memberjoin(Model model){
		model.addAttribute("user", new User());
		return "memberJoin";
	}
}
