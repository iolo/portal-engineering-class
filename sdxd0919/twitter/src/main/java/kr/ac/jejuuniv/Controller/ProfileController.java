package kr.ac.jejuuniv.Controller;

import javax.servlet.http.HttpSession;

import kr.ac.jejuuniv.Model.User;
import kr.ac.jejuuniv.Service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ProfileController {
	@Autowired
	private UserService userService;

	@RequestMapping("/profile")
	public User action(HttpSession session, User newUser){
		int userNum = (Integer) session.getAttribute("userNum");

		return userService.getUser(userNum);
	}
	
	@RequestMapping("/profileSave")
	public String save(HttpSession session, User user){
		userService.update(user);
		
		return "redirect:/personalSNS";
	}
}