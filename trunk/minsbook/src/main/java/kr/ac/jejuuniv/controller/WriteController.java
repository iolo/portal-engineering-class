package kr.ac.jejuuniv.controller;

import kr.ac.jejuuniv.model.Post;
import kr.ac.jejuuniv.service.post.PostService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@RequestMapping("/write")
@SessionAttributes("user")
public class WriteController {
	@Autowired
	PostService postService;
	
	@RequestMapping(method=RequestMethod.GET)
	public String showWritePage() {
		return "write";
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public void write(@ModelAttribute Post newPost) {
		postService.save(newPost);
	}

}
