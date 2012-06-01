package kr.ac.jejuuniv.Repository;

import java.util.List;

import kr.ac.jejuuniv.Model.Tweet;

public interface TweetRepository {

	List<Tweet> findTweetByUserNum(int userNum);

	void deleteTweet(int tweetSeq);

	Tweet getTweetBySeq(int seq);

}
