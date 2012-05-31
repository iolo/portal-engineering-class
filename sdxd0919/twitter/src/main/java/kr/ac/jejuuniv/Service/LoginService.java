package kr.ac.jejuuniv.Service;

import kr.ac.jejuuniv.Model.User;

public interface LoginService {

	User checkUser(String id, String password);

}
