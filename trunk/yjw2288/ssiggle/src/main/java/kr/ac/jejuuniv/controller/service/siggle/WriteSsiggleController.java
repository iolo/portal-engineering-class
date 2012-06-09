package kr.ac.jejuuniv.controller.service.siggle;

import kr.ac.jejuuniv.model.ssiggle.Ssiggle;
import kr.ac.jejuuniv.model.user.User;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/service/writeSsiggle")
public class WriteSsiggleController {
	@RequestMapping(method=RequestMethod.GET)
	public String action(@CookieValue("loginId") String userId, ModelMap model) {
		Ssiggle ssiggle = new Ssiggle();
		ssiggle.setUser(new User().findUserById(userId));
		model.addAttribute("ssiggle", ssiggle);

		return "writeSsiggle";
	}
}
