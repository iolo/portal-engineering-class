package kr.ac.jejuuniv.twitter.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.ac.jejuuniv.twitter.model.TwittModel;
import kr.ac.jejuuniv.twitter.repository.TwitterRepository;
import kr.ac.jejuuniv.twitter.service.TwitterService;

@Service
public class TwitterServiceImpl implements TwitterService{

	@Autowired
	private TwitterRepository twitterRepoistory;
	
	public void writeTwitt(TwittModel twittModel) {
		twitterRepoistory.writeTwitt(twittModel);
	}
	
}
