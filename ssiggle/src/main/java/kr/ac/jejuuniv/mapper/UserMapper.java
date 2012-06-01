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
	
	//TODO : 쿼리문은 맞는다.. 왜 안되는지 물어복;
	List<User> selectAllFollowingUser(String id);
}