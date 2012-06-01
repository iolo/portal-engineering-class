package kr.ac.jejuuniv.Repository;

import kr.ac.jejuuniv.Model.Tweet;
import kr.ac.jejuuniv.Model.User;

public interface UserRepository {
	
	User findByUserNum(int userNum);

	void insert(Tweet tweet);

	User getUserById(String id);

	void insert(User user);

}
