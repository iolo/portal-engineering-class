package kr.ac.jejuuniv.controller;

import kr.ac.jejuuniv.model.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/create")
public class UserCreate {
	
	@RequestMapping
	public void create(User user){
	}
}
