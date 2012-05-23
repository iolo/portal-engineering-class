package kr.ac.jejuuniv.service;

import java.util.List;

import kr.ac.jejuuniv.model.Tweet;
import kr.ac.jejuuniv.repository.TweetRepository;

public class PersonalPageServiceImpl implements PersonalPageService {
	TweetRepository tweetRepository;
	
	public PersonalPageServiceImpl(TweetRepository tweetRepository) {
		this.tweetRepository = tweetRepository;
	}

	public List<Tweet> getPersonalList(String userId) {
		return tweetRepository.findByUserId(userId);
	}
}
