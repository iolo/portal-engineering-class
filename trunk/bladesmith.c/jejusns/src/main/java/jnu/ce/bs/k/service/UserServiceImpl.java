package jnu.ce.bs.k.service;


import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import jnu.ce.bs.k.model.User;
import jnu.ce.bs.k.persistence.UserMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserMapper userMapper;

	@Override
	public void createUser(String id, String password, String name,
			String description, MultipartFile profile) {
		User user;
		String defaultImage;
		
		defaultImage = "default.jpg";
		if (profile.getOriginalFilename() == "") {
			user = new User(id, password, name, description,
					defaultImage);
		} else {
			user = new User(id, password, name, description,
					profile.getOriginalFilename());
			saveImage(profile);
		}

		 userMapper.addUser(user);
	}
	
	@Override
	public void modifyUser(String name, String password, String description,
			MultipartFile profile, User user) {

		user.setName(name);
		user.setPassword(password);
		user.setDescription(description);
		user.setProfile(profile.getOriginalFilename());

		saveImage(profile);

		userMapper.modifyUser(user);
	}
	
	@Override
	public User login(Map<String, String> map) {

		return userMapper.login(map);
	}

	@Override
	public List<User> findAllUser(User user) {
		List<User> users = new ArrayList();
		users = userMapper.findAllUser();

		for (int count = 0; count < users.size(); count++) {
			if (users.get(count).getName().equals(user.getName())) {
				users.remove(count);
			}
		}

		return users;
	}

	public String saveImage(MultipartFile profile) {
		String fileURL = profile.getOriginalFilename();

		File file = new File(
				"C:\\Users\\K\\Documents\\workspace-sts-2.9.0.RELEASE\\jejusns\\src\\main\\webapp\\resources\\profile\\"
						+ fileURL);
		try {
			profile.transferTo(file);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return fileURL;
	}






}
