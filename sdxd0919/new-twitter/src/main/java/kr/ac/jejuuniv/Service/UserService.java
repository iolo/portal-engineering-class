package kr.ac.jejuuniv.Service;

import java.io.IOException;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import kr.ac.jejuuniv.Model.User;

public interface UserService {

	User checkUser(String id, String password);

	User getUserByUserNum(int userNum);

	void addUser(User user, MultipartFile file) throws IOException;

	void update(User user, MultipartFile file) throws IOException;

	List<User> getAllUser();

	User getUserById(String id);

	int getUserNum(String id);

}
