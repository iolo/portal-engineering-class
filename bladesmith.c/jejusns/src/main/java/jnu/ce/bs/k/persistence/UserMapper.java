package jnu.ce.bs.k.persistence;

import java.util.List;
import java.util.Map;

import jnu.ce.bs.k.model.Follow;
import jnu.ce.bs.k.model.Note;
import jnu.ce.bs.k.model.User;

public interface UserMapper {

	public void addUser(User user);

	public User login(Map<String, String> map);
	
	public void writeNote(Note note);

	public List<Note> findAllNoteById(String id);

	public void deleteNoteByWriteNum(String write_num);

	public void modifyUser(User user);

	public List<User> findAllUser();

	public List<Follow> findFollowUserByID(String followerID);

	public void follow(Map<String, String> map);

	public void unfollow(Map<String, String> map);

	public List<User> findFollwingByUserId(String id);

	public List<User> findFollwerByUserId(String id);

	public List<Note> findNoteByUser(User user);

	public List<Note> findNeighborhoodNoteById(String id);
}
