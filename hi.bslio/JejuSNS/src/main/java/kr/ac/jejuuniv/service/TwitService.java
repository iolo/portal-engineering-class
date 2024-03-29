package kr.ac.jejuuniv.service;

import java.util.List;

import kr.ac.jejuuniv.mapper.TwitMapper;
import kr.ac.jejuuniv.model.TwitModel;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TwitService {

	@Autowired
	private TwitMapper twitMapper;
	
	public List<TwitModel> getFollowingTwitList(String id) {
		List<TwitModel> twits = twitMapper.findFollowingTwit(id);
		return twits;
	}
	
	public List<TwitModel> getListByWriter(String writer) {
		List<TwitModel> twits = twitMapper.findByWriter(writer);
		return twits;
	}
	
	public void insertTwit(TwitModel twit) {
		twitMapper.insertTwit(twit);
	}
	
	public void deleteTwit(String id) {
		twitMapper.deleteTwit(id);
	}
	
	public TwitModel findById(String id) {
		return twitMapper.findById(id);		
	}
}
