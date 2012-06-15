package kr.ac.jejuuniv.service;

import org.springframework.ui.Model;

import kr.ac.jejuuniv.model.UserModel;

public interface LoginService {

	UserModel findById(String id);

	boolean loginCheck(String id, String password, Model model);
}
