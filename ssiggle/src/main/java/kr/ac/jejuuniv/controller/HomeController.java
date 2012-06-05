package kr.ac.jejuuniv.controller;

import kr.ac.jejuuniv.model.ssiggle.Ssiggle;
import kr.ac.jejuuniv.model.user.User;
import kr.ac.jejuuniv.service.SsiggleService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestMapping;


//TODO : followerUser.jsp choose 태그 완성
//TODO : following 페이지, follower 페이지, 전체 사용자 페이지에서 following 하는 User를 골라내어, following 하는 User 옆에는 unfollow가 붙도록 한다.
//TODO : jsp 페이지, 우선은 타일즈 안쓴다는 전제하에 html 구성요소 갖추도록 만들것.
@Controller
@RequestMapping("/")
public class HomeController {
	@Autowired
	private SsiggleService ssiggleService;

	@RequestMapping
	public String action(
			@CookieValue(value = "loginId", required = false) String loginId,
			ModelMap model) {
		if (loginId == null || loginId.equals("")) {
			return "login";
		}

		User user = new User().findUserById(loginId);
		
		model.addAttribute("user", user);
		model.addAttribute("ssiggleList", ssiggleService
				.readAllSsiggleByFollowingUser(user, new Ssiggle()));
		return "main";
	}
}