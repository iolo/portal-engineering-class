package kr.ac.jejuuniv.repository;



import kr.ac.jejuuniv.model.LoginModel;
import kr.ac.jejuuniv.model.User;

import org.springframework.stereotype.Repository;

@Repository
public interface LoginMapper {

	User findUserById(LoginModel loginModel);
	
	

}
