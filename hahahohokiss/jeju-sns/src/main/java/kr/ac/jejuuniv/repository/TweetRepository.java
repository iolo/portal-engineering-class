package kr.ac.jejuuniv.repository;

import java.util.List;

import kr.ac.jejuuniv.model.Tweet;

public interface TweetRepository {

	List<Tweet> findByUserId(String string);
}
