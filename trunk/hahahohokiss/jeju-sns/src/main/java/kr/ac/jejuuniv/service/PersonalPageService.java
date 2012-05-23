package kr.ac.jejuuniv.service;

import java.util.List;

import kr.ac.jejuuniv.model.Tweet;


public interface PersonalPageService {

	List<Tweet> getPersonalList(String userId);

	
}
