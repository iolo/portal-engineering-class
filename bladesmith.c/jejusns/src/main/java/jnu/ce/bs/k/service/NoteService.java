package jnu.ce.bs.k.service;

import java.util.List;

import jnu.ce.bs.k.model.Note;
import jnu.ce.bs.k.model.User;

public interface NoteService {

	void writeNote(String writer, String note);
	
	void deleteNoteByWriteNum(String write_num);

	List<Note> findNoteByUser(User user);

	List<Note> findNeighborhoodNoteById(String id);

	List<Note> findAllNoteByID(String id);
}
