package kr.ac.jejuuniv.Controller;

import java.io.IOException;

import kr.ac.jejuuniv.Model.User;
import kr.ac.jejuuniv.Service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class JoinController {

	@Autowired
	private UserService userService;

	@RequestMapping("/join")
	public void action(){
	}
	
	@RequestMapping(value = "/userSave", method=RequestMethod.POST)
	public String save(User user, @RequestParam("file") MultipartFile file) throws IOException{
		userService.addUser(user, file);
		
		return "redirect:/";
	}
	
}
