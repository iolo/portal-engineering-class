package kr.ac.jejuuniv.twitter.service.impl;


import javax.servlet.http.HttpServletRequest;

import kr.ac.jejuuniv.twitter.model.TwittModel;
import kr.ac.jejuuniv.twitter.model.UserModel;
import kr.ac.jejuuniv.twitter.repository.UserRepository;
import kr.ac.jejuuniv.twitter.service.CheckToday;
import kr.ac.jejuuniv.twitter.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpServerErrorException;

@Service
public class UserServiceImpl implements UserService{
	
	@Autowired
	private UserRepository userRepository;

	public void addUser(UserModel user) {
		userRepository.addUser(user);
	}

	public void writeTwitt(TwittModel article) {
		CheckToday today = new CheckToday();
		article.setWritedate(today.Today());
		userRepository.writeTwitt(article);
	}

	public void deleteUser(String id) {
//		userRepository.delUser(id);
	}

	public UserModel checkUser(UserModel user) {
		try {
			UserModel userResult = userRepository.checkUser(user);
			if(userResult==null){
				System.out.println("Try again");
				return null;
			}
			else{
				System.out.println("wow!!!");
				return userResult;
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("error");
		}
		return null;
	}
}
