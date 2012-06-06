package kr.ac.jejuuniv.twitter.service;

import javax.servlet.http.HttpServletRequest;

import kr.ac.jejuuniv.twitter.model.TwittModel;
import kr.ac.jejuuniv.twitter.model.UserModel;

public interface UserService {
	void addUser(UserModel user);
	void writeTwitt(TwittModel article);
	void deleteUser(String id);
	
	UserModel checkUser(UserModel user);
}
