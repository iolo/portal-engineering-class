package kr.ac.jejuuniv.Service;

import kr.ac.jejuuniv.Model.User;
import kr.ac.jejuuniv.Service.Exception.IdNotExistException;

public interface LoginService {

	User checkUser(String id, String password);

}
