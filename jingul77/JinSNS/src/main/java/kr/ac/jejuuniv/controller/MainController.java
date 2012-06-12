package kr.ac.jejuuniv.controller;

import java.util.List;

import kr.ac.jejuuniv.model.UserModel;
import kr.ac.jejuuniv.model.SnsListModel;
import kr.ac.jejuuniv.service.SnsService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@RequestMapping("/main")
@SessionAttributes("user")
public class MainController {
	
	@Autowired
	SnsService snsService;
	
	@RequestMapping()
	public List<SnsListModel> main(@ModelAttribute("user") UserModel user){
		
		return snsService.allGetSns(user.getId());
		
	}
	
}
