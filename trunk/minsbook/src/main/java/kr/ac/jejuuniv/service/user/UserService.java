package kr.ac.jejuuniv.service.user;

import java.util.List;

import org.springframework.ui.Model;
import org.springframework.web.multipart.MultipartFile;

import kr.ac.jejuuniv.model.User;

public interface UserService {

	List<User> getList();

	void saveUser(User user, MultipartFile profileImgPath);

	boolean loginCheck(String id, String password, Model model);
	
	

}