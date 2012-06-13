package kr.ac.jejunu.rabbit.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import kr.ac.jejunu.rabbit.model.Post;
import kr.ac.jejunu.rabbit.model.User;

@Repository
public interface UserMapper {
	
	void UserInsert(User user);
	
	void UserUpdate(User user);
	
	void UserDelete(String userid);

	User findById(String userid);
	
	List<User> findUserAll();
	
	List<Post> findPostAll(String userid);

	void PostInsert(@Param("userid") String postid, @Param("content") String content);

	void followInsert(@Param("userid") String userid, @Param("followerid") String followerid);

	User Check(@Param("userid") String userid, @Param("password") String password);

	void postDelete(@Param("postid") String postid, @Param("post_num") int post_num);
	
}
