package kr.ac.jejuuniv;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

// <<8>> UserModify Controller 생성 및 구현
@Controller
@RequestMapping("/modify")
public class UserModify {
	@Autowired
	UserService userService;
	
	@RequestMapping
	public User modify(String id) {
		return userService.read(id);
	}
}
