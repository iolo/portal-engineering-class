package kr.ac.jejuuniv.service;

import java.util.List;

import kr.ac.jejuuniv.model.Post;

public interface TwitService {

	List<Post> showPostById(String userid);
	

}
