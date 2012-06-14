package kr.ac.jejuuniv.controller;

import javax.servlet.http.HttpSession;

import kr.ac.jejuuniv.model.Post;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/service/writePost")
public class WritePostController {
	
	@RequestMapping(method = RequestMethod.GET)
	public String action(HttpSession session, Model model){
		String userId = (String) session.getAttribute("loginId");
		Post post = new Post();
		post.setUserId(userId);
		model.addAttribute("post", post);
		return "writepost";
	}

}
