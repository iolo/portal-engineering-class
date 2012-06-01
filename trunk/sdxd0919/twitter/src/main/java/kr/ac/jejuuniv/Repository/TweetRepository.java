package kr.ac.jejuuniv.Repository;

import java.util.List;

import kr.ac.jejuuniv.Model.Tweet;

public interface TweetRepository {

	List<Tweet> findTweetByUserNum(int userNum);

	Tweet getTweetBySeq(int seq);

	void insert(Tweet tweet);

	void delete(int seq);

}
