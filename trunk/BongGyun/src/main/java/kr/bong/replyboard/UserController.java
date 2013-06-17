package kr.bong.replyboard;

import javax.servlet.http.HttpSession;

import kr.bong.replyboard.model.User;
import kr.bong.replyboard.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class UserController {

	@Autowired
	UserService userService;

	@RequestMapping(value = "/login")
	public String login() {
		return "user/login";
	}

	@RequestMapping(value = "/loginProcess")
	public String loginProcess(User user, HttpSession session) {

		User loginUser = userService.loginCheck(user.getId(), user.getPassword());

		if (loginUser != null) {
			session.setAttribute("user", loginUser);

			return "redirect:/";
		} else {
			return "redirect:/login?fail=1";
		}
	}

	@RequestMapping(value = "/logout")
	public String logout(HttpSession session) {
		session.setAttribute("user", null);
		return "redirect:/";
	}
}
