package kr.ac.jejuuniv.controller.service.user;

import kr.ac.jejuuniv.model.ssiggle.Ssiggle;
import kr.ac.jejuuniv.model.user.User;
import kr.ac.jejuuniv.service.SsiggleService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/service/main")
public class MainController {
	@Autowired
	private SsiggleService ssiggleService;

	@RequestMapping
	public String action(@CookieValue(value = "loginId") String loginId,
			ModelMap model) {
		User user = new User().findUserById(loginId);

		model.addAttribute("user", user);
		model.addAttribute("ssiggleList", ssiggleService
				.readAllSsiggleByFollowingUser(user, new Ssiggle()));

		return "main";
	}
}
