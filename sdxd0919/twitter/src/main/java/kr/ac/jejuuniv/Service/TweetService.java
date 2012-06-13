package kr.ac.jejuuniv.Service;

import java.util.List;

import kr.ac.jejuuniv.Model.Tweet;
import kr.ac.jejuuniv.Model.UserTweet;

public interface TweetService {

	List<Tweet> getAllTweetByUserNum(int userNum);

	void deleteTweet(int seq);

	void addTweet(Tweet tweet);

	List<Tweet> getAllTweet();

	List<UserTweet> getUserTweet(int userNum);

}
