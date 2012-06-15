package jnu.ce.bs.k.service;

import java.util.List;
import java.util.Map;

import jnu.ce.bs.k.model.User;

public interface FollowService {

	List<User> findFollowUserById(User user);

	void follow(Map<String, String> map);

	void unfollow(Map<String, String> map);

	List<User> findFollowingByUserId(String id);

	List<User> findFollowerByUserId(String id);

}
