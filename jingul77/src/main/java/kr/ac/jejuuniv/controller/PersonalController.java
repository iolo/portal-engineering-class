package kr.ac.jejuuniv.controller;

import java.util.List;

import kr.ac.jejuuniv.model.SnsListModel;
import kr.ac.jejuuniv.model.UserModel;
import kr.ac.jejuuniv.service.SnsService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@RequestMapping("/personal")
@SessionAttributes("user")
public class PersonalController {
	
	@Autowired
	SnsService snsService;
	
	@RequestMapping()
	public List<SnsListModel> personal(@ModelAttribute("user") UserModel user){

		return snsService.personalList(user.getId());		
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/remove")
	public String remove(String index){
		snsService.remove(index);
		
		return "redirect:/personal";
	}
}
