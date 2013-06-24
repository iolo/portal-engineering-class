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
	public String listView(Model model) {
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
		//패스워드 및 아이디는 유저 정보를 받아와 사용. - 미구현
		comment.setPassword("임의 패스워드!");
		comment.setUserId("임의 유저 아이디!");
		commentService.write(comment);
		return "redirect:/";
	}
}
