package com.rillflow.memo;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.rillflow.memo.model.Reply;
import com.rillflow.memo.model.User;
import com.rillflow.memo.service.ReplyService;

@Controller
public class ReplyController {
	
	@Autowired
	ReplyService replyService;
	
	@RequestMapping(value = "/")
	public String list(Model model, HttpServletRequest request) {
		List<Reply> replyList = replyService.getReplyList();
		
		model.addAttribute("replyList", replyList);

		return "reply/list";
	}
	
	@RequestMapping(value = "/write")
	public String write(HttpSession session) {
		User user = (User) session.getAttribute("user");
		
		if(user == null) {
			return "redirect:/login";
		}
		
		return "reply/write";
	}
	
	@RequestMapping(value = "/writeProcess")
	public String writeProcess(HttpSession session, Reply reply) {
		User user = (User) session.getAttribute("user");
		
		reply.setId(user.getId());
		replyService.write(reply);
		
		return "redirect:/";
	}
	
	@RequestMapping(value = "/delete")
	public String write(HttpServletRequest request) {
		int no = Integer.parseInt( request.getParameter("no") );
		
		replyService.delete(no);

		return "redirect:/";
	}
}
