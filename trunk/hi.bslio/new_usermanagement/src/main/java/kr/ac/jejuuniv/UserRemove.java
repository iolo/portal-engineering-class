package kr.ac.jejuuniv;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

// <<7>> UserRemove Controller 생성 및 구현
@Controller
@RequestMapping("/remove")
public class UserRemove {
	@Autowired
	UserService userService;
	
	@RequestMapping
	public String remove(String id) {
		userService.remove(id);		
		return "redirect:/list";		
	}	
}
