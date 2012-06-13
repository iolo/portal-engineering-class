package kr.ac.jejunu.rabbit.contoller;

import kr.ac.jejunu.rabbit.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/save")
public class SaveController {
	@Autowired
	UserService userService;
	
	@RequestMapping
	public String action(@RequestParam("content") String content, @RequestParam("userId") String userId){
		userService.PostInsert(userId, content);
		return "finish";
	}
}
