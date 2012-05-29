package kr.ac.jejuuniv.Repository;

import java.util.List;

import kr.ac.jejuuniv.Model.Tweet;
import kr.ac.jejuuniv.Model.User;

public interface PersonalSnsRepository {

	User findByUserNum(int userNum);

	List<Tweet> findTweetByUserNum(int userNum);

}
