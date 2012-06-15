package kr.ac.jejunu.kdi.repository;

import kr.ac.jejunu.kdi.model.CreateUser;

import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository {

	void createUser(CreateUser user);
	
	CreateUser loginCheck(String userid, String password);
}
