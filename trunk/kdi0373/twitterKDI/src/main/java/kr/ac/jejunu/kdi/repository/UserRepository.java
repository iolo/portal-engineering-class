package kr.ac.jejunu.kdi.repository;

import kr.ac.jejunu.kdi.model.User;

import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository {

	void createUser(User user);

}
