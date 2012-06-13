package jnu.ce.bs.k.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

@RequestMapping
@Controller
@SessionAttributes("User")
public class FollowController {

	@RequestMapping(method = { RequestMethod.POST, RequestMethod.GET }, value="/follow")
	public String follow(@RequestParam("id") String id) {
		
		System.out.println("follow컨");
		System.out.println(id);
		return "redirect:/users.bs";
	}

	@RequestMapping(method = { RequestMethod.POST, RequestMethod.GET }, value="/unfollow")
	public String unFollow(@RequestParam("id") String id) {

		System.out.println("unfollow컨");
		System.out.println(id);
		return "redirect:/users.bs";
	}
}
