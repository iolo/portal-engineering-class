package kr.ac.jejuuniv.Service;

import java.util.List;

import org.mockito.Mock;

import kr.ac.jejuuniv.Model.Tweet;
import kr.ac.jejuuniv.Repository.TweetRepository;

public class TweetServiceImpl implements TweetService {

	private TweetRepository tweetRepository;

	public TweetServiceImpl() {
	}
	
	public TweetServiceImpl(TweetRepository tweetRepository) {
		this.tweetRepository = tweetRepository;
	}

	public List<Tweet> getAllTweet(int userNum) {
		return tweetRepository.findTweetByUserNum(userNum);
	}

	public void deleteTweet(int seq) {
		tweetRepository.delete(seq);
	}

	public void addTweet(Tweet tweet) {
		tweetRepository.insert(tweet);
	}
	

}
