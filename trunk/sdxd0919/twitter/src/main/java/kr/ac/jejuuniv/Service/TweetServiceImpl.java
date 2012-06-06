package kr.ac.jejuuniv.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import kr.ac.jejuuniv.Model.Tweet;
import kr.ac.jejuuniv.Repository.TweetRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TweetServiceImpl implements TweetService {
	
	@Autowired
	private TweetRepository tweetRepository;

	public TweetServiceImpl() {
	}
	
	public TweetServiceImpl(TweetRepository tweetRepository) {
		this.tweetRepository = tweetRepository;
	}

	public List<Tweet> getAllTweetByUserNum(int userNum) {
		return tweetRepository.findTweetByUserNum(userNum);
	}

	public void deleteTweet(int seq) {
		tweetRepository.delete(seq);
	}

	public List<Tweet> getAllTweet() {
		return tweetRepository.getAllTweet();
	}

	public void addTweet(Tweet tweet) {
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.KOREA);
		tweet.setDate(format.format(new Date()));
		
		tweetRepository.insert(tweet);
	}
	

}
