package kr.ac.jejuuniv.Repository;

import kr.ac.jejuuniv.Model.User;

public interface UserRepository {
	
	User findByUserNum(int userNum);
}
