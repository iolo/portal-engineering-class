package kr.ac.jejuuniv.Repository;

import java.util.List;

import kr.ac.jejuuniv.Model.Tweet;

public interface TweetRepository {

	List<Tweet> getTweetByUserNum(int userNum);

	Tweet getTweetBySeq(int seq);

	void delete(int seq);

	List<Tweet> getAllTweet();

	void insert(Tweet tweet);

	List<Integer> getTweetSeq(int userNum);

}

