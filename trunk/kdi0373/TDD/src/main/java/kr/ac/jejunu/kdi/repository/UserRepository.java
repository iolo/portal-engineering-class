package kr.ac.jejunu.kdi.repository;

import kr.ac.jejunu.kdi.model.User;

public interface UserRepository {

	User findById(String id);

	void insert(User user);

}
