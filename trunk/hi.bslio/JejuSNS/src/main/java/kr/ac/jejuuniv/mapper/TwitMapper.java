package kr.ac.jejuuniv.mapper;

import java.util.List;

import kr.ac.jejuuniv.model.TwitModel;

public interface TwitMapper {
	void insertTwit(TwitModel twit);
	List<TwitModel> findAll();
	List<TwitModel> findByWriter(String writer);
	void deleteTwit(String id);
	TwitModel findById(String id);
}
