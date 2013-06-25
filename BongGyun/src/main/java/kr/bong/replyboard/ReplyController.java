package kr.bong.replyboard;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import kr.bong.replyboard.model.Rating;
import kr.bong.replyboard.model.Reply;
import kr.bong.replyboard.model.User;
import kr.bong.replyboard.service.RatingService;
import kr.bong.replyboard.service.ReplyService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ReplyController {
	
	@Autowired
	ReplyService replyService;
	
	@Autowired
	RatingService ratingService;
	
	@RequestMapping(value = "/")
	public String list(Model model, HttpServletRequest request) {
		List<Reply> replyList = replyService.getList();
		String duple = request.getParameter("duple");
		
		model.addAttribute("replyList", replyList);
		model.addAttribute("duple", duple);
		
		return "reply/list";
	}
	
	@RequestMapping(value = "/write")
	public String write(HttpSession session) {
		User user = (User) session.getAttribute("user");
		
		if(user == null) {
			return "redirect:/login?referURL=/write";
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

	@RequestMapping(value = "/upRating")
	public String upRating(HttpSession session, HttpServletRequest request) {
		User user = (User) session.getAttribute("user");
		String strReplyNo = request.getParameter("replyNo");
		int replyNo = Integer.parseInt(strReplyNo);
		
		Rating rating = new Rating();
		rating.setId(user.getId());
		rating.setReplyNo(replyNo);
		
		int result = ratingService.upRating(rating);
		if(result == -1){
			return "redirect:/?duple=1";
		} else {
			return "redirect:/";
		}
	}

	@RequestMapping(value = "/downRating")
	public String downRating(HttpSession session, HttpServletRequest request) {
		User user = (User) session.getAttribute("user");
		String strReplyNo = request.getParameter("replyNo");
		int replyNo = Integer.parseInt(strReplyNo);
		
		Rating rating = new Rating();
		rating.setId(user.getId());
		rating.setReplyNo(replyNo);
		
		int result = ratingService.downRating(rating);
		if(result == -1){
			return "redirect:/?duple=2";
		} else {
			return "redirect:/";
		}
	}
}
