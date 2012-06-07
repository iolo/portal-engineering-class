package kr.ac.jejuuniv.repository;

import java.util.List;

import kr.ac.jejuuniv.model.Tweet;
import kr.ac.jejuuniv.model.User;

public interface UserRepository {

	User findUserByUserId(String userId);

	String findPasswordByUserId(String userId);

	List<Tweet> findTweetByUserId(String userId);

	List<User> findFollowingUserByUserId(String userId);

	List<User> findFollowerUserByUserId(String userId);

	List<User> findAllUser();

	List<Tweet> findFollowingUserTweetByFollowingUser(String userId);

	User updateUser(User user);

	Tweet insertTweet(String userId, Tweet tweet);

}
