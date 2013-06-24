package kr.ac.hyosang.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import kr.ac.hyosang.model.Comment;
import kr.ac.hyosang.model.User;
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
	public String listView(Model model, HttpSession session) {
		
		List<Comment> comment = commentService.getCommentList();
		model.addAttribute("commentList", comment);
		User user = (User) session.getAttribute("user");
		
		if (user != null) {
			model.addAttribute("user", user);
			return "loginUserList";
		} else {
			return "list";
		}
	}
	
	@RequestMapping(value = "/write")
	public String write(Model model, HttpSession session) {
		User user = (User) session.getAttribute("user");
		
		if (user != null) {
			model.addAttribute("user", user);
			return "write";
		} else {
			return "login";
		}
	}
	
	@RequestMapping(value = "/writeprocess")
	public String writeProcess(@ModelAttribute("comment") Comment comment, HttpSession session) {
		User user = (User) session.getAttribute("user");

		comment.setComment(comment.getComment());
		comment.setUserName(user.getUserName());
		comment.setUserId(user.getUserId());
		commentService.write(comment);
		return "redirect:/";
	}

	
	@RequestMapping(value = "/delete")
	public String delete(HttpSession session, HttpServletRequest request) {
		String id = request.getParameter("id");
		commentService.deleteComment(Integer.parseInt(id));
		return "redirect:/";
	}

}
