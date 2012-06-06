package kr.ac.jejuuniv.mapper;

import java.util.List;

import kr.ac.jejuuniv.model.TwitModel;
import kr.ac.jejuuniv.model.UserModel;

public interface TwitMapper {
	void insertTwit(TwitModel twit);
	List<TwitModel> findAll();
	//List<UserModel> findAllOrderByIdDesc();
}
