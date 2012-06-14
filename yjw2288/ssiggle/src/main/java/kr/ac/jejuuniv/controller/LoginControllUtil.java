package kr.ac.jejuuniv.controller;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

public class LoginControllUtil {
	public static String saveCookie4Login(String id, HttpServletResponse response) {
		response.addCookie(new Cookie("loginId", id));

		return "redirect:/service/main/";
	}
}
