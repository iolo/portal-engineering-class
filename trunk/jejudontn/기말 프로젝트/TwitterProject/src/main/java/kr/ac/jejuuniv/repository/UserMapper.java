package kr.ac.jejuuniv.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import kr.ac.jejuuniv.model.AllFollow;
import kr.ac.jejuuniv.model.AllUsers;
import kr.ac.jejuuniv.model.FollowIdTemp;
import kr.ac.jejuuniv.model.User;

@Repository
public interface UserMapper {

	void createUser(User user);

	void modifyUser(User user);

	List<AllUsers> findAlluser();

	List<AllFollow> findAllFollow(String id);

	void deleteFollow(FollowIdTemp followTemp);

	void createFollow(FollowIdTemp followTemp);

}
