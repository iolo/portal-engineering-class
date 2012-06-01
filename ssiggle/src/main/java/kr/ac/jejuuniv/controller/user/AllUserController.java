package kr.ac.jejuuniv.controller.user;

import kr.ac.jejuuniv.model.user.User;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/service/allUser")
public class AllUserController {
	@RequestMapping
	public String action(ModelMap model) {
		model.addAttribute("allUser", new User().findAllUser());
		return "allUser";
	}
}
