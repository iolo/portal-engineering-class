package kr.ac.jejunu.rabbit.contoller;

import javax.servlet.http.HttpServletRequest;

import kr.ac.jejunu.rabbit.model.User;
import kr.ac.jejunu.rabbit.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/login")
public class LoginController {

	@Autowired
	private UserService userService;

	@RequestMapping
	public String action(@RequestParam(value = "userid") String userid,	@RequestParam(value = "password") String password,
			HttpServletRequest request, Model model) {
		boolean value = userService.Login(userid, password);
		if (value != true) {
			return "main";
		}
		User user = userService.UserGet(userid);
		request.getSession().setAttribute("loginId", userid);
		model.addAttribute("user", user);
		model.addAttribute("posts", userService.GetUserPost(userid));

		return "redirect:/";
	}
}