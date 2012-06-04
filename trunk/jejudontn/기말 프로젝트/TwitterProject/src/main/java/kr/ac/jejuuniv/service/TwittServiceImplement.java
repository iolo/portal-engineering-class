package kr.ac.jejuuniv.service;

import java.util.List;

import kr.ac.jejuuniv.model.Twitt;
import kr.ac.jejuuniv.model.TwittList;
import kr.ac.jejuuniv.repository.TwiitMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TwittServiceImplement implements TwittService {



	@Autowired
	TwiitMapper twiitMapper;
	@Autowired
	ServiceUtility serviceUtility;
	
	
	@Override
	public void createTwiit(String id, String twiit) {
		
		
		String twiitId = id + System.currentTimeMillis();
		String mTime = serviceUtility.getTime();
		Twitt maketwiit = new Twitt(id, twiit, mTime, twiitId);
		
		
		twiitMapper.createTwiit(maketwiit);
		
		
	}
	
	@Override
	public List<TwittList> getPersonalTwiit(String id) {
		

		return twiitMapper.getPersonalTwiit(id);


	}

	@Override
	public void removeTwitt(String twittId) {
		twiitMapper.removeTwitt(twittId);
		
	}

	@Override
	public List<TwittList> getFollowingTwitt(String id) {

		return twiitMapper.getFollowingTwitt(id);


		
	}

}
