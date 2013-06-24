package kr.bong.replyboard.service.impl;

import java.io.File;
import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import kr.bong.replyboard.model.User;
import kr.bong.replyboard.repository.UserDao;
import kr.bong.replyboard.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	public static final String PROFILE_IMAGE_PATH = 
			"C:/BongGyun/project/spring/workspace/ReplyBoard/src/main/webapp/resources/profile/";
	
	@Autowired
	UserDao userDao;
	
	@Override
	public int join(User user) {
		uploadAndMove(user);
		
		return userDao.insertUser(user);
	}

	@Override
	public int modify(User user) {
		uploadAndMove(user);
		
		return userDao.updateUser(user);
	}

	@Override
	public User getUser(String id) {
		return userDao.selectUser(id);
	}

	@Override
	public User loginCheck(String id, String password) {
		User user = userDao.selectUser(id);
		
		if(user != null && user.getPassword().equals(password))
			return user;
		else
			return null;
	}

	/**
	 * 파일 이동 수행 및 파일명 지정
	 */
	private void uploadAndMove(User user) {
		MultipartFile uploadFile = user.getProfFile();
		String fileName = user.getId() + ".jpg"; 
		user.setProfPath(fileName);
		
		File file = new File(PROFILE_IMAGE_PATH + fileName);
		
		try {
			uploadFile.transferTo(file);
		} catch (IllegalStateException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
