package kr.ac.jejunu;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.ac.jejunu.model.Comment;
import kr.ac.jejunu.repositry.SqlMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class CommentController {
	
	@Autowired
	private SqlMapper mapper;
	
	@RequestMapping
	public String errorPage(){
		return "error";
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
