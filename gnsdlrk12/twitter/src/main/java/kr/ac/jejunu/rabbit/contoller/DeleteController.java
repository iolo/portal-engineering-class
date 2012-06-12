package kr.ac.jejunu.rabbit.contoller;

import kr.ac.jejunu.rabbit.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/delete")
public class DeleteController {
	@Autowired
	UserService userService;
	
	@RequestMapping
	public String deletePost(@RequestParam("postid") String postid, @RequestParam("post_num") int post_num){		
		userService.postDelete(postid, post_num);
		return "redirect:/";
	}
}
