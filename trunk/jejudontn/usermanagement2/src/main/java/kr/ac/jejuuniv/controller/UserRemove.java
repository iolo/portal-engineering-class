package kr.ac.jejuuniv.controller;

import kr.ac.jejuuniv.Service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/remove")
public class UserRemove {
	
	@Autowired
	private UserService userService;
	@RequestMapping(method = RequestMethod.GET)
	public String delete(@RequestParam("id") String id){
		userService.deleteUserList(id);
		return "redirect:/list";
	}

}
