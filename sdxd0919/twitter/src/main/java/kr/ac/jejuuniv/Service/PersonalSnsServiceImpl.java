package kr.ac.jejuuniv.Service;

import java.util.List;

import kr.ac.jejuuniv.Model.Tweet;
import kr.ac.jejuuniv.Model.User;
import kr.ac.jejuuniv.Repository.PersonalSnsRepository;

public class PersonalSnsServiceImpl implements PersonalSnsService {

	private PersonalSnsRepository personalSnsRepository;

	public PersonalSnsServiceImpl() {
	}
	
	public PersonalSnsServiceImpl(PersonalSnsRepository personalSnsRepository) {
		this.personalSnsRepository = personalSnsRepository;
	}

	public User getUser(int userNum) {
		return personalSnsRepository.findByUserNum(userNum);
	}

	public List<Tweet> getTweet(int userNum) {
		return personalSnsRepository.findTweetByUserNum(userNum);
	}

	public void deleteTweet(int tweetSeq) {
		personalSnsRepository.deleteTweet(tweetSeq);
	}

}
