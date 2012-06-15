package kr.ac.jejuuniv.controller;

import org.springframework.beans.factory.annotation.Autowired;

import kr.ac.jejuuniv.service.UserService;

public class BaseFormController {
	@Autowired
	UserService userService;
}
