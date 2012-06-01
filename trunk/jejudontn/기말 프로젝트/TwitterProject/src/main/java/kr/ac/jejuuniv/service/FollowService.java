package kr.ac.jejuuniv.service;

import java.util.List;

import kr.ac.jejuuniv.model.AllUsers;

public interface FollowService {

	List<AllUsers> getFollower(String id);

}
