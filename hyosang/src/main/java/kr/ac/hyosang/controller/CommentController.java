package kr.ac.hyosang.controller;

import java.util.List;

import kr.ac.hyosang.model.Comment;
import kr.ac.hyosang.repository.CommentDao;
import kr.ac.hyosang.service.CommentService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class CommentController {
	@Autowired
	CommentService commentService;
	
	@RequestMapping(value = "/")
	public String home(Model model) {
		List<Comment> comment = commentService.getCommentList();
		model.addAttribute("commentList", comment);
		
		return "home";
	}
	
}
