package jnu.ce.bs.k.service;

import java.util.List;
import java.util.Map;

import jnu.ce.bs.k.model.Note;
import jnu.ce.bs.k.model.User;

public interface UserService {

	void createUser(String id, String password, String name,
			String description, String profile);

	 User login(Map<String, String> map);

	List<Note> findAllNoteByID(String id);

	void modifyUser(User user);

}
