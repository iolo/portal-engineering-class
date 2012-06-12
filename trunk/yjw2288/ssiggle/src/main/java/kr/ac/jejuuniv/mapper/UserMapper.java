package kr.ac.jejuuniv.mapper;

import java.util.List;

import kr.ac.jejuuniv.model.user.User;

//TODO : UserMapper.xml 좀 간단하게 바꿀 수 없을까? 중복되는 부분 많아.
public interface UserMapper {
	User selectUserById(String id);

	void updateUser(User user);

	void insertUser(User user);

	void deleteUser(String id);

	List<User> selectAllUser();

	List<User> selectAllFollowingUser(String id);

	List<User> selectAllFollowerUser(String id);
}