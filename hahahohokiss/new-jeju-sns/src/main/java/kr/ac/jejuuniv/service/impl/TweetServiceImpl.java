package kr.ac.jejuuniv.service.impl;

import java.util.List;

import kr.ac.jejuuniv.model.Tweet;
import kr.ac.jejuuniv.repository.TweetRepository;
import kr.ac.jejuuniv.repository.UserRepository;
import kr.ac.jejuuniv.service.TweetService;

public class TweetServiceImpl implements TweetService {
	
	TweetRepository tweetRepository;
	UserRepository userRepository;
	
	public TweetServiceImpl() {
		
	}
		
	public TweetServiceImpl(TweetRepository tweetRepository) {
		this.tweetRepository = tweetRepository;
	}

	public List<Tweet> getTweetByUserId(String id) {
		
		return tweetRepository.findByUserId(id);
	}

	public Tweet saveTweet(Tweet tweet) {
		return tweetRepository.save(tweet);
	}

}
