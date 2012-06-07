package kr.ac.jejuuniv.repository;



import java.util.Map;

import kr.ac.jejuuniv.model.User;

import org.springframework.stereotype.Repository;

@Repository
public interface LoginMapper {

	User findUserById(Map<String, String> loginMap);
	
	

}
