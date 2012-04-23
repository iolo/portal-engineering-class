package kr.ac.jejuuniv.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/save")
public class CreateUser {
	public String action(@RequestParam("id") String id,
			@RequestParam("name") String name,
			@RequestParam("password") String password, ModelMap model) {
		return "list";
	}
}
