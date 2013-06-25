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
	
	private static final int PAGE_COUNT = 10;
	
	@Autowired
	ReplyService replyService;
	
	@Autowired
	RatingService ratingService;
	
	@RequestMapping(value = "/")
	public String list(Model model, HttpServletRequest request) {
		String strPage = request.getParameter("page");
		int page = 0;
		try{
			page = Integer.parseInt(strPage);
		} catch(Exception e) {
		}
		
		List<Reply> replyList = replyService.getList(page*PAGE_COUNT);
		
		int replyCount = replyService.getCount();
		String duple = request.getParameter("duple");
		
		model.addAttribute("replyList", replyList);
		model.addAttribute("duple", duple);
		if(page-1 >= 0)
			model.addAttribute("prevPage", page-1);
		
		if(page+1 <= replyCount/PAGE_COUNT)
			model.addAttribute("nextPage", page+1);
		
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
	
	@RequestMapping(value = "/delete")
	public String write(HttpServletRequest request) {
		String strReplyNo = request.getParameter("replyNo");
		int replyNo = Integer.parseInt(strReplyNo);
		
		replyService.delete(replyNo);

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
