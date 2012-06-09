package jnu.ce.bs.k.controller;

import java.util.HashMap;
import java.util.Map;

import jnu.ce.bs.k.model.User;
import jnu.ce.bs.k.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

@Controller
@SessionAttributes("User")
public class UserLoginController {

	@Autowired
	private UserService userService;

	@RequestMapping(method = RequestMethod.GET, value = "/login")
	public void loginAction() {
	}

	@RequestMapping(method = RequestMethod.POST, value = "/login")
	public String loginAction(String id, String password, Model model) {
		Map<String, String> map = new HashMap<String, String>();
		map.put("id", id);
		map.put("password", password);

		User user = userService.login(map);

		if (user != null) {
			model.addAttribute("User", user);

			return "redirect:/myjeju.bs";
		} else {
			return "redirect:/";
		}
	}

	@RequestMapping(method = { RequestMethod.POST, RequestMethod.GET }, value = "/logout")
	public String logout(@ModelAttribute("User") User user,
			SessionStatus sessionStatus) {

		sessionStatus.setComplete();

		return "redirect:/";
	}
}
