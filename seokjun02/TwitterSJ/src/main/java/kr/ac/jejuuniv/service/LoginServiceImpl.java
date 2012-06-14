package kr.ac.jejuuniv.service;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import kr.ac.jejuuniv.mapper.UserMapper;
import kr.ac.jejuuniv.model.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class LoginServiceImpl implements LoginService {

	@Autowired
	private UserMapper userMapper;

	@Override
	public boolean checkUser(String id, String password) {
		return (userMapper.checkUser(id, password) == 1) ? true : false;
	}

	@Override
	public boolean checkId(String userid) {
		return (userMapper.checkId(userid) == 1) ? true : false;
	}

	@Override
	public void saveUser(User user) {
		if (userMapper.checkId(user.getUserId()) == 0) {
			userMapper.insertUser(user);
		} else {
			userMapper.updateUser(user);
		}
	}

	@Override
	public void saveImage(MultipartFile file, User user) throws IOException {
		String fileType = getFileType(file);

		File uploadedFile = new File(
				"D:/Dev/STS/.metadata/.plugins/org.eclipse.wst.server.core/tmp2/wtpwebapps/TwitterSJ/resources/images/"
						+ user.getUserId() + fileType);

		if (uploadedFile.exists()) {
			uploadedFile.delete();
		}
		uploadedFile.createNewFile();

		FileOutputStream fos = new FileOutputStream(uploadedFile);
		fos.write(file.getBytes());
		fos.close();

		user.setPhoto(user.getUserId() + fileType);
	}

	private String getFileType(MultipartFile file) {
		switch (file.getContentType()) {
			case "image/jpg" :
			case "image/jpeg" :
				return ".jpg";
			case "image/gif" :
				return ".gif";
			case "image/png" :
				return ".png";
		}
		throw new RuntimeException("올바른 파일이 아닙니다.");
	}

	@Override
	public User findUserById(String userId) {

		return userMapper.selectUser(userId);
	}
}
