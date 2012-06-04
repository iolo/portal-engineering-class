package kr.ac.jejuuniv.service;

import java.util.List;

import kr.ac.jejuuniv.model.AllUsers;

import org.springframework.web.multipart.MultipartFile;

public interface UserService {

	void createUser(String id, String password, String name,
			String information, MultipartFile profileImage);

	void modifyUser(String id, String password, String name,
			String information, MultipartFile profileImage);

	List<AllUsers> findAlluser(String id);


	void FollowUser(String id, String follow, String followid);

}
