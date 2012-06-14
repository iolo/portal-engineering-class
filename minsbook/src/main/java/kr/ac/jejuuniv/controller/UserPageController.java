package kr.ac.jejuuniv.controller;

import java.util.List;

import kr.ac.jejuuniv.model.Post;
import kr.ac.jejuuniv.model.User;
import kr.ac.jejuuniv.service.post.PostService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@RequestMapping("/user")
@SessionAttributes("user")
public class UserPageController {
	
	@Autowired
	PostService postService;
	
	@RequestMapping()
	public List<Post> personal(@ModelAttribute("user") User user){

		return postService.getPosts(user.getId());		
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/remove")
	public String remove(int index){
		postService.delete(index);
		
		return "redirect:/personal";
	}
}