package jnu.ce.bs.k.service;

import java.util.List;

import jnu.ce.bs.k.model.Note;
import jnu.ce.bs.k.model.User;
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

	@Override
	public void deleteNoteByWriteNum(String write_num) {
		userMapper.deleteNoteByWriteNum(write_num);
	}

	@Override
	public List<Note> findNoteByUser(User user) {
		return userMapper.findNoteByUser(user);
	}

	@Override
	public List<Note> findNeighborhoodNoteById(String id) {
		return userMapper.findNeighborhoodNoteById(id);
	}

}
