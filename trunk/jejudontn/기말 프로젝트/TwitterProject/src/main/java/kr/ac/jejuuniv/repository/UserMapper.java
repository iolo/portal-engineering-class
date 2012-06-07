package kr.ac.jejuuniv.repository;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import kr.ac.jejuuniv.model.AllFollow;
import kr.ac.jejuuniv.model.AllUsers;
import kr.ac.jejuuniv.model.User;

@Repository
public interface UserMapper {

	void createUser(User user);

	void modifyUser(User user);

	List<AllUsers> findAlluser(String id);

	List<AllFollow> findAllFollow(String id);

	void deleteFollow(Map<String, String> addFollower);

	void createFollow(Map<String, String> addFollower);

	List<AllUsers> getFollowing(String id);

	List<AllUsers> getFollower(String id);

}
