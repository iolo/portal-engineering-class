package jnu.ce.bs.k.controller;

import java.util.List;

import jnu.ce.bs.k.model.Note;
import jnu.ce.bs.k.model.User;
import jnu.ce.bs.k.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;


@Controller
@RequestMapping("/myjeju.bs")
@SessionAttributes("User")
public class UsersJejuSNSController {
	
	@Autowired
	private UserService userService;
	
	@RequestMapping
	public List<Note> action(@ModelAttribute("User") User user){

		return userService.findAllNoteByID(user.getId());
	}

}
