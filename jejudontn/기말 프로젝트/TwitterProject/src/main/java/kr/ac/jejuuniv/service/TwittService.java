package kr.ac.jejuuniv.service;

import java.util.List;

import kr.ac.jejuuniv.model.TwittList;

public interface TwittService {

	void createTwiit(String id, String twiit);

	List<TwittList> getPersonalTwiit(String id);

	void removeTwitt(String twittId);
}
