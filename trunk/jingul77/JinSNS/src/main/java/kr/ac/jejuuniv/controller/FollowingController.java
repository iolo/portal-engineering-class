package kr.ac.jejuuniv.controller;

import java.util.List;

import kr.ac.jejuuniv.model.TotalUserModel;
import kr.ac.jejuuniv.service.FollowService;
import kr.ac.jejuuniv.service.SnsService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@RequestMapping("/following")
@SessionAttributes("user")
public class FollowingController {
	
	@Autowired
	SnsService snsService;
	
	@Autowired
	FollowService followService;
	
	@RequestMapping()
	public List<TotalUserModel> following(@ModelAttribute("User")TotalUserModel user){
		return followService.getList(user.getId());
		
	}	
}
