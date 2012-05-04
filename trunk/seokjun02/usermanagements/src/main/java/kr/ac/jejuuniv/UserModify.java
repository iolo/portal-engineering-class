package kr.ac.jejuuniv;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/modify")
public class UserModify {
	
	@Autowired
	private UserService userService;
	
	public User action(String id){
		return userService.get(id); 
	}
}
