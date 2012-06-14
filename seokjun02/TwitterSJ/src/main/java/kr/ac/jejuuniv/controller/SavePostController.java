package kr.ac.jejuuniv.controller;

import kr.ac.jejuuniv.model.Post;
import kr.ac.jejuuniv.service.TwitService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/service/savePost")
public class SavePostController {
	@Autowired
	private TwitService twitService;
	
	@RequestMapping
	public String action(@ModelAttribute Post post){
		twitService.savePost(post);
		return "close";
	}

}
