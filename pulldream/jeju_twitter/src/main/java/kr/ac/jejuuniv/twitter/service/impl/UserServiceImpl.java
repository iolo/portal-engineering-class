package kr.ac.jejuuniv.twitter.service.impl;


import javax.servlet.http.HttpServletRequest;

import kr.ac.jejuuniv.twitter.model.TwittModel;
import kr.ac.jejuuniv.twitter.model.UserModel;
import kr.ac.jejuuniv.twitter.repository.UserRepository;
import kr.ac.jejuuniv.twitter.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpServerErrorException;

@Service
public class UserServiceImpl implements UserService{
	
	@Autowired
	private UserRepository userRepository;

	//회원 가입
	public void addUser(UserModel user) {
		userRepository.addUser(user);
	}

	public void writeTwitt(TwittModel article) {
		userRepository.writeTwitt(article);
	}

	public void deleteUser(String id) {
//		userRepository.delUser(id);
	}

	//로그인할려는 사용자 인증
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
