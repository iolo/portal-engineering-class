package kr.ac.jejuuniv;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/create")
public class UserCreate {
	
	@Autowired
	private UserService userService;
	
	@RequestMapping
	public String action(User user) {
		userService.create(user);
		return "redirect:/list";
	}

}
