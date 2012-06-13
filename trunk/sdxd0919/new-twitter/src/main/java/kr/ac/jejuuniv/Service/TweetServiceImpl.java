package kr.ac.jejuuniv.Service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import kr.ac.jejuuniv.Model.Tweet;
import kr.ac.jejuuniv.Model.User;
import kr.ac.jejuuniv.Model.UserTweet;
import kr.ac.jejuuniv.Repository.TweetRepository;
import kr.ac.jejuuniv.Service.Exception.dateIsNullException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TweetServiceImpl implements TweetService {
	
	@Autowired
	private TweetRepository tweetRepository;
	@Autowired
	private UserService userService;

	public TweetServiceImpl() {
	}
	
	public TweetServiceImpl(TweetRepository tweetRepository) {
		this.tweetRepository = tweetRepository;
	}

	public List<Tweet> getAllTweetByUserNum(int userNum) {
		return tweetRepository.getTweetByUserNum(userNum);
	}

	public void deleteTweet(int seq) {
		tweetRepository.delete(seq);
	}

	public List<Tweet> getAllTweet() {
		return tweetRepository.getAllTweet();
	}

	public void addTweet(Tweet tweet) {
		if(tweet.getMessage().equals("")){
			throw new dateIsNullException();
		}else{
			SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.KOREA);
			tweet.setDate(format.format(new Date()));
			
			tweetRepository.insert(tweet);
		}
	}

	public List<UserTweet> getUserTweet(int userNum) {
		List<Integer> tweetSeq = tweetRepository.getTweetSeq(userNum);
		List<UserTweet> userTweets = new ArrayList<UserTweet>();
		
		for(int i=0; i<tweetSeq.size(); i++){
			int seq = tweetSeq.get(i);
			
			Tweet tweet = tweetRepository.getTweetBySeq(seq);
			User user = userService.getUserByUserNum(tweet.getUserNum());
			userTweets.add(new UserTweet(tweet, user));
		}
		
		return userTweets;
	}
}
