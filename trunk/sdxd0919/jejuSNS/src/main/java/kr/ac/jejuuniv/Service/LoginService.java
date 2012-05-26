package kr.ac.jejuuniv.Service;

import kr.ac.jejuuniv.Model.User;

public interface LoginService {

	Boolean checkUser(String id, String password);

}
