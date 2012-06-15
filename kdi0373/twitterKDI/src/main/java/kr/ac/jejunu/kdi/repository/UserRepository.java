package kr.ac.jejunu.kdi.repository;

import kr.ac.jejunu.kdi.model.CreateUser;
import kr.ac.jejunu.kdi.model.User;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository {

	void createUser(CreateUser user);
	
	User loginCheck(@Param("id") String id, @Param("password") String password);
}
