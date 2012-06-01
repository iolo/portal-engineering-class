package kr.ac.jejuuniv.controller;

import kr.ac.jejuuniv.model.user.User;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestMapping;

//TODO : 로그인 처리 다시 확인, 로그인 안되었을때 처리 및 로그인 다시 해보기
@Controller
@RequestMapping("/")
public class HomeController {
	@RequestMapping
	public String action(
			@CookieValue(value = "loginId", required = false) String loginId,
			ModelMap model) {
		if (loginId == null || loginId.equals("")) {
			return "login";
		}

		User user = new User().findUserById(loginId);

		model.addAttribute("user", user);
		//TODO : 나중에 팔로워들의 Ssiggle을 읽는 코드로 변환
//		model.addAttribute("allUser", user.findAllUser());
		return "main";
	}
}