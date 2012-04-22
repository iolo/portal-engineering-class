package kr.ac.jejuuniv.controller;

import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping()
public class Main {
	@RequestMapping
	public String action() {
		return "index";
	}
}
