package kr.juntheater.controller;

import kr.juntheater.model.User;
import kr.juntheater.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/save")
public class UserCreate {
	@Autowired
	private UserService userService;
	
	@RequestMapping
	public String insert(String id, String name, String password){
		System.out.println(id+"id??");
		if(userService.readId(id)==null){
			userService.create(new User(id, name, password));
		}
		else	userService.modify(new User(id,name,password));
		return "redirect:/list";
	}
}
