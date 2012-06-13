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

	List<User> findAllUser(User user);

	void modifyUser(String name, String password, String description,
			String profile, User user);

	List<User> findFollowUserById(User user);

	void follow(Map<String, String> map);

	void unfollow(Map<String, String> map);

	List<User> findFollowingByUserId(String id);

}
