package kr.ac.jejunu;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {
	
	@RequestMapping
	public String list() {
		return "list";
	}
	
	@RequestMapping("/join")
	public String join() {
		return "join";
	}
	@RequestMapping("/login")
	public String login() {
		return "login";
	}
}
