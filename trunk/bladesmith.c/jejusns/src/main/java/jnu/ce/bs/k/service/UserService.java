package jnu.ce.bs.k.service;

import java.util.List;
import java.util.Map;

import jnu.ce.bs.k.model.User;

import org.springframework.web.multipart.MultipartFile;

public interface UserService {

	void createUser(String id, String password, String name,
			String description, MultipartFile profile);

	User login(Map<String, String> map);

	List<User> findAllUser(User user);

	void modifyUser(String name, String password, String description,
			MultipartFile profile, User user);

}
