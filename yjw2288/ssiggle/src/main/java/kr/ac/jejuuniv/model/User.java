package kr.ac.jejuuniv.model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import kr.ac.jejuuniv.mapper.UserMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;

@Configurable
public class User implements Serializable {
	private static final long serialVersionUID = 1584661762891063902L;

	@Autowired
	private UserMapper userMapper;

	private String id;
	private String password;
	private String name;
	private String introduce;
	private String image = "DefaultUserImage.jpg";

	private Set<User> followingUser = new HashSet<>();
	private Set<User> followerUser = new HashSet<>();

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getIntroduce() {
		return introduce;
	}

	public void setIntroduce(String introduce) {
		this.introduce = introduce;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public Set<User> getFollowingUser() {
		return followingUser;
	}

	public void setFallowingUser(Set<User> followingUser) {
		this.followingUser = followingUser;
	}

	public Set<User> getFallowerUser() {
		return followerUser;
	}

	public void setFollowerUser(Set<User> followerUser) {
		this.followerUser = followerUser;
	}

	public User findUserById(String id) {
		return userMapper.selectUserById(id);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "User [id=" + id + "]";
	}
}