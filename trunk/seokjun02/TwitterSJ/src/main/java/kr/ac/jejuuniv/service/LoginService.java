package kr.ac.jejuuniv.service;

public interface LoginService {

	void memberLogin(String id, String password);

	boolean checkUser(String id, String password);

}
