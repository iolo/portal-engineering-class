package kr.ac.jejuuniv.service;

import java.util.List;

import kr.ac.jejuuniv.model.Post;
import kr.ac.jejuuniv.model.User;

public interface TwitService {

	List<Post> showPostById(String userid);

	void deleteUserPost(String userId, long sequenceNumber);

	User getUser(String userId);

	void savePost(Post post);

	List<User> getAllUser();

	List<String> checkFollow(String userId);

	List<User> getFollowingUser(String userId);

	List<User> getFollowerUser(String userId);
	

}
