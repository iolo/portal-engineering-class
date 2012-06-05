package kr.ac.jejuuniv.model;

import java.util.Set;

import kr.ac.jejuuniv.mapper.UserMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;

//TODO : User user = new UserImpl() 이런거 어떨까? 괜히 코드만 어렵게 만드는거 아닌가?
@Configurable
public class UserImpl implements User {
	private static final long serialVersionUID = 1584661762891063902L;

	@Autowired
	private UserMapper userMapper;

	private String id;
	private String password;
	private String name;
	private String introduce;
	private String image = "DefaultUserImage.jpg";

	public UserImpl() {
	}

	public UserImpl(UserMapper userMapper) {
		this.userMapper = userMapper;
	}

	@Override
	public UserMapper getUserMapper() {
		return userMapper;
	}

	@Override
	public void setUserMapper(UserMapper userMapper) {
		this.userMapper = userMapper;
	}

	@Override
	public String getId() {
		return id;
	}

	@Override
	public void setId(String id) {
		this.id = id;
	}

	@Override
	public String getPassword() {
		return password;
	}

	@Override
	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String getName() {
		return name;
	}

	@Override
	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String getIntroduce() {
		return introduce;
	}

	@Override
	public void setIntroduce(String introduce) {
		this.introduce = introduce;
	}

	@Override
	public String getImage() {
		return image;
	}

	@Override
	public void setImage(String image) {
		this.image = image;
	}

	// TODO : 로그인 후 글 읽기 다 한 후에 테스트를 한다.
	@Override
	public Set<User> getFollowingUser() {
		return null;
	}

	@Override
	public void setFallowingUser(Set<User> followingUser) {
	}

	@Override
	public Set<User> getFallowerUser() {
		return null;
	}

	@Override
	public void setFollowerUser(Set<User> followerUser) {
	}

	@Override
	public User findUser(String id, String password) {
		User user = userMapper.selectUserById(id);
		if (user == null) {
			throw new NotFoundUserException("찾으시는 User " + id
					+ " 이(가) 존재하지 않습니다.");
		}

		if (!user.getPassword().equals(password)) {
			return null;
		}

		return user;
	}

	@Override
	public void save() {
		if (userMapper.selectUserById(this.getId()) == null) {
			userMapper.insertUser(this);
		} else {
			userMapper.updateUser(this);
		}
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
		UserImpl other = (UserImpl) obj;
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