package kr.ac.jejuuniv.service;

import java.io.IOException;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import kr.ac.jejuuniv.model.Tweet;
import kr.ac.jejuuniv.model.User;

public interface UserService {

	User getUser(String userId);

	String getPassword(String userId);

	List<Tweet> getTweets(String userId);

	List<User> getFollowingUser(String userId);

	List<UserDto> getFollowerUser(String userId);

	List<UserDto> getAllUser(String userId);

	List<Tweet> getFollowingTweet(String userId);

	User modifyUser(User user);

	void addFollow(String followId, String followingId);

	Tweet addTweet(String userId, Tweet tweet);

	void removeTweet(String userId, int tweetId);

	User addUser(User user, MultipartFile file) throws IOException;

	void removeFollow(String followId, String followingId);


}
