package kr.ac.jejuuniv.twitter.service.impl;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.ac.jejuuniv.twitter.model.FollowModel;
import kr.ac.jejuuniv.twitter.model.FollowModel;
import kr.ac.jejuuniv.twitter.model.TwittModel;
import kr.ac.jejuuniv.twitter.model.UserModel;
import kr.ac.jejuuniv.twitter.repository.TwitterRepository;
import kr.ac.jejuuniv.twitter.repository.UserRepository;
import kr.ac.jejuuniv.twitter.service.TwitterService;

@Service
public class TwitterServiceImpl implements TwitterService{

	@Autowired
	private TwitterRepository twitterRepoistory;
	
	public void writeTwitt(TwittModel twittModel) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"); 
		twittModel.setWrite_date(dateFormat.format(new Date()));
		twitterRepoistory.writeTwitt(twittModel);
	}
	
	public void deleteMyTwitt(int twinum) {
		twitterRepoistory.deleteMyTwitt(twinum);
	}

	public List<TwittModel> getTwittList(String id) {
		return twitterRepoistory.getTwittListOderByDate(id);
	}


	public List<TwittModel> getMyTwittList(String id) {
		return twitterRepoistory.getMyTwittOrderByDate(id);
	}


	
}
