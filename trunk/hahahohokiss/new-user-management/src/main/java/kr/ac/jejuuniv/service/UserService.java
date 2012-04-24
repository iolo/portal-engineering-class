package kr.ac.jejuuniv.service;

import java.util.List;

import kr.ac.jejuuniv.model.User;

public interface UserService {

	List<User> list();

	User get(String id);

}
