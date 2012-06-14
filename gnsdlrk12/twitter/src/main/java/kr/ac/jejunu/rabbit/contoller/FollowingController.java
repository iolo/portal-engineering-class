package kr.ac.jejunu.rabbit.contoller;

import javax.servlet.http.HttpSession;

import kr.ac.jejunu.rabbit.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/following")
public class FollowingController {
	@Autowired
	private UserService userService;

	@RequestMapping()
	public String action(@RequestParam(value = "userid") String userid, Model model, HttpSession session) {
		userid = (String)session.getAttribute("loginId");
		model.addAttribute("loginUser", userService.UserGet(userid));
		model.addAttribute("user", userService.followingList(userid));
		return "following";
	}
}
