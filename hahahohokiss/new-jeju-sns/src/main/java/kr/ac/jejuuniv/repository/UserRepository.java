package kr.ac.jejuuniv.repository;

import kr.ac.jejuuniv.model.User;

public interface UserRepository {

	User findUserByUserId(String userId);

}
