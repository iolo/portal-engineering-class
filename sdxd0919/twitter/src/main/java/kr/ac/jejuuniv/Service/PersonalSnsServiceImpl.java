package kr.ac.jejuuniv.Service;

import java.util.List;
import kr.ac.jejuuniv.Model.Tweet;
import kr.ac.jejuuniv.Model.User;
import kr.ac.jejuuniv.Repository.TweetRepository;
import kr.ac.jejuuniv.Repository.UserRepository;

public class PersonalSnsServiceImpl implements PersonalSnsService {

	private UserRepository userRepository;
	private TweetRepository tweetRepository;

	public PersonalSnsServiceImpl() {
	}
	
	public PersonalSnsServiceImpl(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	public PersonalSnsServiceImpl(TweetRepository tweetRepository) {
		this.tweetRepository = tweetRepository;
	}

	public User getUser(int userNum) {
		return userRepository.findByUserNum(userNum);
	}

	public List<Tweet> getTweet(int userNum) {
		return tweetRepository.findTweetByUserNum(userNum);
	}

	public void deleteTweet(int tweetSeq) {
		tweetRepository.deleteTweet(tweetSeq);
	}

}
