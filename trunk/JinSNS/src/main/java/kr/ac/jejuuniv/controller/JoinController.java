package kr.ac.jejuuniv.controller;

import kr.ac.jejuuniv.service.JoinService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@Controller
@RequestMapping("/join")
public class JoinController {
		
	@Autowired
	JoinService joinService;
	
	@RequestMapping()
	public void action(){
		
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public String joinUser(@RequestParam("id") String id,
						   @RequestParam("password")String password, @RequestParam("name")String name, 
						   @RequestParam("explain")String explain, @RequestParam("image") MultipartFile image)
	{
		joinService.joinUser(id, password, name, explain, image);
		
		return "redirect:/login";
	}
	
}
