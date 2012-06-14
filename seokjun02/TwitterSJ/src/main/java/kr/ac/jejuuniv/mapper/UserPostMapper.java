package kr.ac.jejuuniv.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import kr.ac.jejuuniv.model.Post;

public interface UserPostMapper {

	List<Post> showPostByUserId(String userid);

	void deleteUserPost(@Param("userId") String userId,	@Param("sequenceNumber") long sequenceNumber);

	void insertPost(Post post);

}
