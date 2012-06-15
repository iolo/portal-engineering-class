package kr.ac.jejunu.kdi.controller;



import kr.ac.jejunu.kdi.service.LoginService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/login")
public class Login {
	
	@Autowired
	LoginService loginService;
	
	@RequestMapping()
	public void loginView(){
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public String login(@RequestParam("id") String id,
						@RequestParam("password") String password){
		
		if(loginService.login(id,password)){
			return "redirect:/main";
		}else{
			return "redirect:/login";
		}
		
		
	}

}
