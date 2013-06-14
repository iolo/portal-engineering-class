package kr.bong.replyboard;

import java.text.DateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import kr.bong.replyboard.model.Reply;
import kr.bong.replyboard.service.ReplyService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);

	@Autowired
	ReplyService replyService;
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String list(Model model) {
		
		List<Reply> replyList = replyService.getList();
		
		model.addAttribute("replyList", replyList);
		
		return "list";
	}
}
