package kr.ac.jejunu;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class CommentController {
	
	@RequestMapping
	public String errorPage(){
		return "error";
	}
	
	@RequestMapping("/")
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
	@RequestMapping("/write")
	public String write() {
		return "write";
	}
}
