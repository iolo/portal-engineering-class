package jnu.ce.bs.k.persistence;

import java.util.List;
import java.util.Map;

import jnu.ce.bs.k.model.Note;
import jnu.ce.bs.k.model.User;

public interface UserMapper {

	public void addUser(User user);

	public User login(Map<String, String> map);
	
	public void writeNote(Note note);

	public List<Note> findAllNoteById(String id);

	public void deleteNoteByWriteNum(String write_num);
}
