package kr.ac.jejuuniv.controller;

import java.util.List;

import kr.ac.jejuuniv.model.TotalUserModel;
import kr.ac.jejuuniv.model.UserModel;
import kr.ac.jejuuniv.service.SnsService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@RequestMapping("/alluser")
@SessionAttributes("user")
public class AllUserController {
	
	@Autowired
	SnsService snsService;
	
	@RequestMapping()
	public List<TotalUserModel> alluser(@ModelAttribute("user") UserModel user){
		
		return snsService.totalUser(user.getId());
	}	
}
