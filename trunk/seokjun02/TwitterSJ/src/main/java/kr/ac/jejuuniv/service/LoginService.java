package kr.ac.jejuuniv.service;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.springframework.web.multipart.MultipartFile;

import kr.ac.jejuuniv.model.User;

public interface LoginService {

	boolean checkUser(String id, String password);

	boolean checkId(String userid);

	void saveUser(User user);

	void saveImage(MultipartFile file, User user) throws IOException, FileNotFoundException;

	User findUserById(String userId);

}
