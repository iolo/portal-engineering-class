package kr.ac.jejuuniv.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import kr.ac.jejuuniv.model.Post;
import kr.ac.jejuuniv.model.User;
import kr.ac.jejuuniv.service.TwitService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/personal")
public class PersonalMain {
	@Autowired
	private TwitService twitService;

	@RequestMapping
	public List<Post> action(Model model, User user, HttpSession session) {

		String userId = (String) session.getAttribute("loginId");
		return twitService.showPostById(userId);
	}

}
