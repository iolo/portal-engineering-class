package kr.ac.jejuuniv.service;

import java.util.List;

import kr.ac.jejuuniv.model.TotalUserModel;

public interface FollowService {

	List<TotalUserModel> getList(String id);

}
