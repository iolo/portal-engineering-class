package kr.ac.jejuuniv.Service;

import java.util.List;

import kr.ac.jejuuniv.Model.Tweet;
import kr.ac.jejuuniv.Model.User;

public interface PersonalSnsService {

	User getUser(int userNum);

	List<Tweet> getTweet(int userNum);

	void deleteTweet(int tweetSeq);

}
