package net.daum.springframework.openseminar.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/redirect/hello")
public class RedirectViewController {
	
	@RequestMapping
	public String hello() {
		System.out.println("****************  redirect view controller *****************");
		return "redirect:/bean_name_hello";
	}
}