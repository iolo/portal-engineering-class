package kr.ac.jejuuniv.controller;

import java.util.List;

import kr.ac.jejuuniv.model.Ssiggle;
import kr.ac.jejuuniv.model.User;
import kr.ac.jejuuniv.service.SsiggleService;
import kr.ac.jejuuniv.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestMapping;

//TODO : 하이버네이트 암호화 방법 물어보기
@Controller
@RequestMapping("/")
public class HomeController {
	@Autowired
	private SsiggleService ssiggleService;
	@Autowired
	private UserService userService;

	@RequestMapping
	public String action(
			@CookieValue(value = "loginId", required = false) String loginId,
			ModelMap model) {
		if (loginId == null || loginId.equals("")) {
			return "loginpage";
		}

		List<Ssiggle> ssiggleList = ssiggleService
				.ssiggleListByUserIdDesTime(loginId);
		User user = userService.findUserById(loginId);
		user.setPassword("");

		model.addAttribute("ssigglelist", ssiggleList);
		model.addAttribute("user", user);
		return "mainsns";
	}
}