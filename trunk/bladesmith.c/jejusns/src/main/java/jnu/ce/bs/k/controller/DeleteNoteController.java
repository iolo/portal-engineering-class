package jnu.ce.bs.k.controller;

import jnu.ce.bs.k.service.NoteService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@SessionAttributes("User")
@RequestMapping("/remove")
public class DeleteNoteController {
	
	@Autowired
	private NoteService noteService;
	
	@RequestMapping
	public String action(@RequestParam("write_num") String write_num){
		noteService.deleteNoteByWriteNum(write_num);
		
		return "redirect:/myjeju.bs";
	}
}
