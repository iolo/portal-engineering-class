package jnu.ce.bs.k.controller;

import java.util.List;

import jnu.ce.bs.k.model.Note;
import jnu.ce.bs.k.service.NoteService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;


@Controller
@SessionAttributes("User")
@RequestMapping("/neighborhood.bs")
public class NeighborhoodController {

	@Autowired
	private NoteService noteService;
	
	@RequestMapping(method = RequestMethod.GET)
	public List<Note> Action(@RequestParam("id") String id){
		
		return noteService.findNeighborhoodNoteById(id);
	}
}
