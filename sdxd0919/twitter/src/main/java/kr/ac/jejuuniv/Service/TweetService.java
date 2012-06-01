package kr.ac.jejuuniv.Service;

import java.util.List;

import kr.ac.jejuuniv.Model.Tweet;

public interface TweetService {

	List<Tweet> getAllTweet(int seq);

	void deleteTweet(int seq);

	void addTweet(Tweet tweet);

}
