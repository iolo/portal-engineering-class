package kr.ac.jejuuniv.controller;

import java.util.List;

import kr.ac.jejuuniv.User;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/list")
public class UserList {
	
	@RequestMapping
	public List<User> action(){
		System.out.println("**************************************");
		return null;
	}
	

}
