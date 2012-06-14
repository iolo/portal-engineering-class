package kr.ac.jejuuniv.mapper;

import java.util.List;

import kr.ac.jejuuniv.model.User;

import org.apache.ibatis.annotations.Param;


public interface UserMapper {
	int checkUser(@Param("userId") String id, @Param("password") String password);

	int checkId(String userid);
	
	void insertUser(User user);

	User selectUser(String userId);

	void updateUser(User user);

	List<User> selectAllUser();

	List<String> checkFollow(String userId);

}
