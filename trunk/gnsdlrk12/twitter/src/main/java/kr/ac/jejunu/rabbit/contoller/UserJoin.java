package kr.ac.jejunu.rabbit.contoller;

import kr.ac.jejunu.rabbit.model.User;
import kr.ac.jejunu.rabbit.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/userjoin")
public class UserJoin {
	@Autowired
	UserService userService;
	
	@RequestMapping
	public String userReg(@RequestParam(value = "userid") String userid, @RequestParam(value = "password") String password,
			@RequestParam(value = "name") String name, @RequestParam(value = "introduce") String introduce){
		User user = new User();
		user.setUserid(userid);
		user.setPassword(password);
		user.setName(name);
		user.setIntroduce(introduce);
		
		userService.UserInsert(user);
				return "finish";		
	}
}
