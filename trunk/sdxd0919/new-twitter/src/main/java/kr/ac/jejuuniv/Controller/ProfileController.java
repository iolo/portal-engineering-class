package kr.ac.jejuuniv.Controller;

import java.io.IOException;

import javax.servlet.http.HttpSession;

import kr.ac.jejuuniv.Model.User;
import kr.ac.jejuuniv.Service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class ProfileController {
	@Autowired
	private UserService userService;

	@RequestMapping("/service/profile")
	public User action(HttpSession session, User newUser){
		int userNum = (Integer) session.getAttribute("userNum");

		return userService.getUserByUserNum(userNum);
	}
	
	@RequestMapping(value = "/service/profileSave", method=RequestMethod.POST)
	public String save(HttpSession session, User user, 
			@RequestParam("file") MultipartFile file) throws IOException{
		userService.update(user, file);

		return "redirect:/service/personalSNS";
	}

}
