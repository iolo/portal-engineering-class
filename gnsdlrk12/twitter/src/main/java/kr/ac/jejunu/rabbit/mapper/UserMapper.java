package kr.ac.jejunu.rabbit.mapper;

import java.util.List;

import kr.ac.jejunu.rabbit.model.AllFollow;
import kr.ac.jejunu.rabbit.model.AllUser;
import kr.ac.jejunu.rabbit.model.Post;
import kr.ac.jejunu.rabbit.model.User;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UserMapper {
	
	void UserInsert(User user);
	
	void UserUpdate(User user);
	
	void UserDelete(String userid);

	User findById(String userid);
	
	List<User> followingUserAll(String userid);
	
	List<Post> findPostAll(String userid);

	void PostInsert(@Param("userid") String postid, @Param("content") String content);

	void followInsert(@Param("userid") String userid, @Param("followerid") String followerid);

	User Check(@Param("userid") String userid, @Param("password") String password);

	void postDelete(@Param("postid") String postid, @Param("post_num") int post_num);

	void UserUnfollow(@Param("userid") String userid, @Param("followerid") String followerid);

	List<User> followerUserAll(String userid);
	
	List<AllUser> getAllUser(String userid);
	
	List<AllFollow> getAllFollow(String userid);

	void userFollow(@Param("userid") String userid, @Param("followerid") String followerid);
}
