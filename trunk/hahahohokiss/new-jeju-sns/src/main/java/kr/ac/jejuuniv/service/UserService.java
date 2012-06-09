package kr.ac.jejuuniv.service;

import java.util.List;

import kr.ac.jejuuniv.model.Tweet;
import kr.ac.jejuuniv.model.User;

public interface UserService {

	User getUser(String userId);

	String getPassword(String userId);

	List<Tweet> getTweets(String userId);

	List<User> getFollowingUser(String userId);

	List<User> getFollowerUser(String userId);

	List<User> getAllUser();

	List<Tweet> getFollowingTweet(String userId);

	User modifyUser(User user);

	void addFollow(String followId, String followingId);

	Tweet addTweet(String userId, Tweet tweet);

	void removeTweet(String userId, int tweetId);

	User addUser(User user);

	void removeFollow(String followId, String followingId);


}
