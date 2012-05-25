package kr.ac.jejuuniv.service;

import org.springframework.web.multipart.MultipartFile;

public interface UserService {

	void createUser(String id, String password, String name,
			String information, MultipartFile profileImage);

}
