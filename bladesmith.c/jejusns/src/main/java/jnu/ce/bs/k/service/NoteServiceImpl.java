package jnu.ce.bs.k.service;

import jnu.ce.bs.k.model.Note;
import jnu.ce.bs.k.persistence.UserMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class NoteServiceImpl implements NoteService{

	@Autowired
	private UserMapper userMapper;
	
	@Override
	public void writeNote(String writer, String data) {
		Note note = new Note(writer, data);
		userMapper.writeNote(note);
	}

}
