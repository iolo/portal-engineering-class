package kr.ac.jejuuniv.mapper;

import java.util.List;

import kr.ac.jejuuniv.model.user.User;

//TODO : UserMapper.xml 좀 간단하게 바꿀 수 없을까? 중복되는 부분 많아.
public interface UserMapper {
	User selectUserById(String id);

	void updateUser(User user);

	void insertUser(User user);

	List<User> selectAllUser();

	void deleteUser(String id);

	// TODO : 이 둘은 여기에 있는게 맞겠지?
	List<User> selectAllFollowingUser(String id);

	List<User> selectAllFollowerUser(String id);
}
