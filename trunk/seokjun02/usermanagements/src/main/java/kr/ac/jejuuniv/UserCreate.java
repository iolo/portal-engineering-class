package kr.ac.jejuuniv;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class UserCreate {
	
	@Autowired
	private UserService userService;
	
	public String action(User user) {
		userService.save(user);
		return "redirect:/list";
	}

}
