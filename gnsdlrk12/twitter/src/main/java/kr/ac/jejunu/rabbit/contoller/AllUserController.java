package kr.ac.jejunu.rabbit.contoller;

import java.util.List;

import javax.servlet.http.HttpSession;

import kr.ac.jejunu.rabbit.model.AllUserList;
import kr.ac.jejunu.rabbit.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/alluser")
public class AllUserController {
	@Autowired
	UserService userService;
	List<AllUserList> allfollowerUser;
	
	@RequestMapping
	public String allUserList(@RequestParam(value="userid") String userid, Model model, HttpSession session){
		userid = (String)session.getAttribute("loginId");
		model.addAttribute("loginUser", userService.UserGet(userid));		
		userService.followerList(userid);
		model.addAttribute("user", userService.followerList(userid));		
		allfollowerUser = userService.setAllFollow(userService.getAllUserList(userid), userService.getAllFollowList(userid));		
		model.addAttribute("alluser", allfollowerUser);
		return "allUserPage";
	}
}
