package kr.ac.hyosang.controller;

import java.util.List;

import kr.ac.hyosang.model.Comment;
import kr.ac.hyosang.service.CommentService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class CommentController {
	@Autowired
	CommentService commentService;
	
	@RequestMapping(value = "/")
	public String home(Model model) {
		List<Comment> comment = commentService.getCommentList();
		model.addAttribute("commentList", comment);
		
		return "list";
	}
	
	
	@RequestMapping(value = "/write")
	public String write() {
		return "write";
	}
	
	@RequestMapping(value = "/writeprocess")
	public String writeProcess(@ModelAttribute("comment") Comment comment) {
		comment.setComment(comment.getComment());
		comment.setPassword("임의 페스워드! 유저 모델 만든 다음에 유저 페스워드로 입력되도록 수정합시다.");
		commentService.write(comment);
		return "redirect:/";
	}
	
}
