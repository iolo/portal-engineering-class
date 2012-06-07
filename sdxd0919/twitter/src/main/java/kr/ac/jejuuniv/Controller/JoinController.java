package kr.ac.jejuuniv.Controller;

import javax.servlet.http.HttpSession;

import kr.ac.jejuuniv.Model.User;
import kr.ac.jejuuniv.Service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/join")
public class JoinController {
	@Autowired
	private UserService userService;

	@RequestMapping
	public User action(HttpSession session){
		int userNum = (Integer) session.getAttribute("userNum");
		
		return userService.getUser(userNum);
	}
}
