package kr.ac.jejuuniv.repository;

import org.springframework.stereotype.Repository;

import kr.ac.jejuuniv.model.User;

@Repository
public interface UserMapper {

	void createUser(User user);

	void modifyUser(User user);

}
