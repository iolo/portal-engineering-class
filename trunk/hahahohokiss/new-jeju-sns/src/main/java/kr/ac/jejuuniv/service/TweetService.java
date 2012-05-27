package kr.ac.jejuuniv.service;

import java.util.List;

import kr.ac.jejuuniv.model.Tweet;

public interface TweetService {

	List<Tweet> getTweetByUserId(String id);

	Tweet saveTweet(Tweet tweet);

}
