package kr.ac.jejuuniv.twitter.service;

import javax.servlet.http.HttpServletRequest;

import kr.ac.jejuuniv.twitter.model.TwittModel;
import kr.ac.jejuuniv.twitter.model.UserModel;

public interface UserService {
	//사용자 가입
	void addUser(UserModel user);
	//자신의 글 쓰기
	void writeTwitt(TwittModel article);
	//사용자 삭제
	void deleteUser(String id);
	//사용자 점검
	UserModel checkUser(UserModel user);
}
