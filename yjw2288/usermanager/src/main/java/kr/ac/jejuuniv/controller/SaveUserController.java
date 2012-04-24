package kr.ac.jejuuniv.controller;

import kr.ac.jejuuniv.model.User;
import kr.ac.jejuuniv.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/save")
public class SaveUserController {
	@Autowired
	private UserService service;

	@RequestMapping(method = RequestMethod.GET)
	public String saveUserGet(@RequestParam("id") String id,
			@RequestParam("name") String name,
			@RequestParam("password") String password, ModelMap model) {
		User user = new User(id, name, password);
		service.save(user);

		// TODO : (생각해보기)이 부분이 약간 꺼림직함, 좋은 해결 방안이 없을까......
		model.addAttribute("userList", service.listUser());
		return "list";
	}

	@RequestMapping(method = RequestMethod.POST)
	public String saveUserPost(@ModelAttribute User user, BindingResult result) {
		return null;
	}
}