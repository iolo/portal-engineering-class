package kr.ac.jejunu.rabbit.contoller;

import javax.servlet.http.HttpSession;

import kr.ac.jejunu.rabbit.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/write")
public class WritingControler {
	@Autowired
	UserService userService;
	
	@RequestMapping
	public String PostWriting(HttpSession session, Model model){
		model.addAttribute("userId", session.getAttribute("loginId"));
		return "write";
	}
}
