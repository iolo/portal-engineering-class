package kr.ac.jejuuniv.mapper;

import kr.ac.jejuuniv.model.UserModel;

import org.springframework.stereotype.Repository;

@Repository
public interface JoinMapper {
	
	void joinUser(UserModel user);
	
}
