package kr.ac.jejuuniv.controller;

import javax.servlet.http.HttpSession;

import kr.ac.jejuuniv.service.TwitService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/service/deleteUserPost")
public class DeleteUserPostController {
	@Autowired
	private TwitService twitService;
	
	@RequestMapping(method=RequestMethod.GET)
	public String action(HttpSession session, long sequenceNumber){
		String userId = (String) session.getAttribute("loginId");
		twitService.deleteUserPost(userId, sequenceNumber);
		return "redirect:/service/personal";
	}
}
