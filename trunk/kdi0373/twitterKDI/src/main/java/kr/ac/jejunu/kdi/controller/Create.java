package kr.ac.jejunu.kdi.controller;

import kr.ac.jejunu.kdi.service.CreateService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping ("/create")
public class Create {
	
	@Autowired
	private CreateService createService;
	
	@RequestMapping
	public void createView(){
		System.out.println("asdfafafafaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
	}
	
	@RequestMapping( method = RequestMethod.POST)
	public String createUser(@RequestParam("id") String id,
							 @RequestParam("password") String password,
							 @RequestParam("name") String name,
							 @RequestParam("memo") String memo,
							 @RequestParam("image") String image) {
								
		createService.createUser(id, password, name, memo, image);
		System.out.println("bbbbbbg");
		return "redirect:/login";
	}
	
	
		
}
