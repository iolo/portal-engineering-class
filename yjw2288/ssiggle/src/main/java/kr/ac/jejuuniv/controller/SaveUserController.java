package kr.ac.jejuuniv.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import kr.ac.jejuuniv.model.user.User;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@Controller
@RequestMapping("/saveUser")
public class SaveUserController {
	@RequestMapping(method = RequestMethod.POST)
	public String action(
			@ModelAttribute User user,
			@RequestParam(value = "imageFile", required = false) MultipartFile file,
			HttpServletResponse response) throws IOException {

		if (file != null && !file.isEmpty()) {
			user.saveImage(file);
		}
		user.save();

		return LoginControllUtil.saveCookie4Login(user.getId(), response);
	}
}