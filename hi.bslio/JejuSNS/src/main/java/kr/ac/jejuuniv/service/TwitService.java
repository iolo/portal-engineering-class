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
	
	public List<TwitModel> getList() {
		List<TwitModel> twits = twitMapper.findAll();
		return twits;
	}
	
	public void insertTwit(TwitModel twit) {
		twitMapper.insertTwit(twit);
	}
}
