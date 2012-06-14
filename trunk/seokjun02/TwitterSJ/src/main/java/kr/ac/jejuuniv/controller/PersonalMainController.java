package kr.ac.jejuuniv.controller;

import javax.servlet.http.HttpSession;

import kr.ac.jejuuniv.model.User;
import kr.ac.jejuuniv.service.TwitService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/service/personal")
public class PersonalMainController {
	@Autowired
	private TwitService twitService;
	
	@RequestMapping
	public String action(Model model, HttpSession session) {

		String userId = (String) session.getAttribute("loginId");
		User user = twitService.getUser(userId);

		model.addAttribute("user", user);
		model.addAttribute("postList", twitService.showPostById(userId));

		return "personal";
	}

}
