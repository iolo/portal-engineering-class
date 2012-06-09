package kr.ac.jejuuniv.controller.service.user;

import kr.ac.jejuuniv.model.user.User;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/service/modifyUser")
public class ModifyUserController {
	@RequestMapping(method = RequestMethod.GET)
	public String action(@CookieValue("loginId") String id, ModelMap modelMap) {
		User user = new User().findUserById(id);
		user.setPassword("");

		modelMap.addAttribute("user", user);
		return "userModify";
	}
}
