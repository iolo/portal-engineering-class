package kr.bong.replyboard;

import java.util.List;

import kr.bong.replyboard.model.Reply;
import kr.bong.replyboard.service.ReplyService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class HomeController {
	
	@Autowired
	ReplyService replyService;
	
	@RequestMapping(value = "/", method = RequestMethod.POST)
	public String list(Model model) {
		
		List<Reply> replyList = replyService.getList();
		
		model.addAttribute("replyList", replyList);
		
		return "list";
	}
}
