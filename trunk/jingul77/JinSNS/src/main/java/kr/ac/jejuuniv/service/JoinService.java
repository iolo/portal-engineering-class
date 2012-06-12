package kr.ac.jejuuniv.service;

import org.springframework.web.multipart.MultipartFile;

public interface JoinService {

	void joinUser(String id, String password, String name, String explain,MultipartFile image);

}
