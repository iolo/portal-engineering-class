package kr.bong.replyboard;

import java.util.List;

import javax.servlet.http.HttpSession;

import kr.bong.replyboard.model.Reply;
import kr.bong.replyboard.model.User;
import kr.bong.replyboard.service.ReplyService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class ReplyController {
	
	@Autowired
	ReplyService replyService;
	
	@RequestMapping(value = "/")
	public String list(Model model) {
		List<Reply> replyList = replyService.getList();
		
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
		
		return "reply/writeProcess";
	}
}
