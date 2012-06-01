package kr.ac.jejuuniv.controller.user;

import kr.ac.jejuuniv.model.user.User;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/service/modifyUser")
public class ModifyUserController {
	@RequestMapping(method = RequestMethod.GET)
	public String action(@RequestParam String id, ModelMap modelMap) {
		User user = new User().findUserById(id);
		user.setPassword("");

		modelMap.addAttribute("user", user);
		return "userModify";
	}
}