package kr.ac.jejuuniv.service;

import kr.ac.jejuuniv.model.User;

public interface LoginService {

	boolean checkIdAndPassword(String id, String password);


	User findUserById(String id);




}
