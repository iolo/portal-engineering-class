package kr.ac.jejuuniv.mapper;

import java.util.List;

import kr.ac.jejuuniv.model.Post;

public interface UserPostMapper {

	List<Post> showPostById(String userid);
	
}
