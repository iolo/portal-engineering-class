package kr.ac.jejuuniv.repository;

import java.util.List;

import kr.ac.jejuuniv.model.Twitt;
import kr.ac.jejuuniv.model.TwittList;

import org.springframework.stereotype.Repository;

@Repository
public interface TwiitMapper {

	List<TwittList> getPersonalTwiit(String id);
	
	void createTwiit(Twitt maketwiit);

	void removeTwitt(String twittId);

	List<TwittList> getFollowingTwitt(String id);

}
