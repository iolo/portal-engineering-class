package kr.ac.jejuuniv.service;

import org.springframework.web.multipart.MultipartFile;

public interface JoinService {

	public String saveFile(MultipartFile image);

	void joinUser(String id, String password, String name, String explain,MultipartFile image);

	void UpdateUser(String id, String password, String name, String explain,MultipartFile image);

}
