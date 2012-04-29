package kr.ac.jejuuniv;
import java.util.List;

import kr.ac.jejuuniv.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/list")
public class UserList {
	@Autowired
	UserService userService;
	
	@RequestMapping
	public List<User> action(){
		return userService.list();
	}
	
}
