package kr.ac.jejuuniv.controller;


import kr.ac.jejuuniv.model.UserModel;
import kr.ac.jejuuniv.service.SnsService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@RequestMapping("/write")
@SessionAttributes("user")
public class WirteController {
	
	
	@Autowired
	SnsService snsService;
	
	@RequestMapping()
	public void action(){
		
	}
	
	@RequestMapping(value = "/write", method = RequestMethod.POST)
	public void wirteSns(@ModelAttribute("user")UserModel user, @RequestParam("sns")String sns){
		snsService.writeSns(user.getId(), sns);
	}
}
