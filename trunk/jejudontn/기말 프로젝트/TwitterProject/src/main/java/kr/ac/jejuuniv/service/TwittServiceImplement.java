package kr.ac.jejuuniv.service;

import java.util.List;

import kr.ac.jejuuniv.model.Twitt;
import kr.ac.jejuuniv.model.TwittList;
import kr.ac.jejuuniv.repository.TwittMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TwittServiceImplement implements TwittService {



	@Autowired
	TwittMapper twittMapper;
	@Autowired
	ServiceUtility serviceUtility;
	
	
	@Override
	public void createTwitt(String id, String twiit) {
		
		
		String twiitId = id + System.currentTimeMillis();
		String mTime = serviceUtility.getTime();
		Twitt maketwiit = new Twitt(id, twiit, mTime, twiitId);
		
		
		twittMapper.createTwiit(maketwiit);
		
		
	}
	
	@Override
	public List<TwittList> getPersonalTwiit(String id) {
		

		return twittMapper.getPersonalTwiit(id);


	}

	@Override
	public void removeTwitt(String twittId) {
		twittMapper.removeTwitt(twittId);
		
	}

	@Override
	public List<TwittList> getFollowingTwitt(String id) {

		return twittMapper.getFollowingTwitt(id);


		
	}

}
