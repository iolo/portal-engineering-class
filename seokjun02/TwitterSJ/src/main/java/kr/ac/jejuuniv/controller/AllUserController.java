package kr.ac.jejuuniv.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import kr.ac.jejuuniv.model.User;
import kr.ac.jejuuniv.service.TwitService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/service/alluser")
public class AllUserController {
	@Autowired
	private TwitService twitService;

	@RequestMapping
	public String action(HttpSession session, Model model) {
		String userId = (String) session.getAttribute("loginId");
		User user = twitService.getUser(userId);
		model.addAttribute("user", user);
		
		List<User> users = twitService.getAllUser();
		model.addAttribute("userList", users);

		return "alluser";
	}

}
