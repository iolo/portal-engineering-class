package jnu.ce.bs.k.controller;

import jnu.ce.bs.k.model.User;
import jnu.ce.bs.k.service.NoteService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@SessionAttributes("User")
@RequestMapping("/write")
public class WriteController {
	
	@Autowired
	private NoteService noteService;
	
	@RequestMapping(method = RequestMethod.GET, value = "/write")
	public void getAction(@ModelAttribute("User") User user){
		
	}
	
	@RequestMapping(method = RequestMethod.POST, value = "/write")
	public void postAction(@ModelAttribute("User") User user,
					@RequestParam("note") String note) {
		noteService.writeNote(user.getId(), note);
	}
}
