package kr.juntheater.controller;

import java.util.List;
import java.util.Map;

import kr.juntheater.model.User;
import kr.juntheater.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/list")
public class UserList {
	
	@Autowired
	private UserService userService;
	
	@RequestMapping
	public List<User> action(){
		System.out.println(userService.getList().get(0).getId());
		return userService.getList();
	}
}
