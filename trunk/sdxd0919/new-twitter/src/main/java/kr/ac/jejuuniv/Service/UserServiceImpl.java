package kr.ac.jejuuniv.Service;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import kr.ac.jejuuniv.Model.User;
import kr.ac.jejuuniv.Repository.UserRepository;
import kr.ac.jejuuniv.Service.Exception.UserNotFoundException;
import kr.ac.jejuuniv.Service.Exception.dateIsNullException;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	UserRepository userRepository;

	public UserServiceImpl() {
	}
	
	public UserServiceImpl(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	public User checkUser(String id, String password) {
		String userPassword = userRepository.getPassword(id);
		
		if(userPassword.equals(password)){
			return userRepository.getUserById(id);
		}
		return null;
	}

	public User getUserByUserNum(int userNum) {
		return userRepository.getUserByUserNum(userNum);
	}

	public void addUser(User user, MultipartFile file) throws IOException {
		if(userRepository.getUserByUserNum(user.getUserNum()) != null){
			throw new DuplicateKeyException("동일한 id가 있습니다.");
		}else{
			user.setProfileImg(getImagePath(user, file));
			userRepository.insert(user);
		}
	}


	public void update(User newUser, MultipartFile file) throws IOException {
		User user = userRepository.getUserByUserNum(newUser.getUserNum()); 
		if(user == null){
			throw new UserNotFoundException();
		}else{
			if(newUser.getName().equals("")) newUser.setName(user.getName());
			if(newUser.getPassword().equals("")) newUser.setPassword(user.getPassword());

			newUser.setProfileImg(getImagePath(user, file));
			userRepository.update(newUser);
		}
	}

	public List<User> getAllUser() {
		return userRepository.getAllUser();
	}

	public User getUserById(String id) {
		return userRepository.getUserById(id);
	}

	public int getUserNum(String id) {
		return userRepository.getUserNumById(id);
	}

	public String getImagePath(User user, MultipartFile file) throws IOException {
		byte[] byteFile = file.getBytes();
		String name = file.getOriginalFilename(); 
		String imagePath = user.getProfileImg();
		if(!name.equals("")){
			
			String path = "/Users/HSY/Documents/workspace-sts-2.9.0.RELEASE/workspace/PortalService/new-twitter/src/main/webapp/resources/profileImg";
			path = path + "/" + user.getId() + "/";
			
			File dirPaht = new File(path);
			if(!dirPaht.exists()){
				dirPaht.mkdir();
			}
			
			File uploadedFile = new File(path + name);
			FileOutputStream fos;
			fos = new FileOutputStream(uploadedFile);
			fos.write(byteFile);
			fos.close();
			
			imagePath = "/twitter/resources/profileImg/" + user.getId() + "/" + name;
		}
		return imagePath;
	}
}
