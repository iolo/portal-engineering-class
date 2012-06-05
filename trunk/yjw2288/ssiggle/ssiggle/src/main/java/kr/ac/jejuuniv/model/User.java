package kr.ac.jejuuniv.model;

import java.io.Serializable;
import java.util.Set;

import kr.ac.jejuuniv.mapper.UserMapper;

import org.springframework.transaction.annotation.Transactional;

@Transactional
public interface User extends Serializable {

	@Transactional(readOnly = true)
	User findUser(String id, String password);

	void setFollowerUser(Set<User> followerUser);

	Set<User> getFallowerUser();

	void setFallowingUser(Set<User> followingUser);

	Set<User> getFollowingUser();

	void setImage(String image);

	String getImage();

	void setIntroduce(String introduce);

	String getIntroduce();

	void setName(String name);

	String getName();

	void setPassword(String password);

	String getPassword();

	void setId(String id);

	String getId();

	public void setUserMapper(UserMapper userMapper);

	public UserMapper getUserMapper();

	void save();
}
