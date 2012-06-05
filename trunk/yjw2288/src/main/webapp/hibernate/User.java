package kr.ac.jejuuniv.model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;

//TODO : 이거 설정 방법 물어보기, 일반 클래스는 잘 작동하는되 @Entity 만 붙이면 잘 안되는 거 같음
//@Configurable
@Entity
@Table(name = "user")
public class User implements Serializable {
	private static final long serialVersionUID = 1584661762891063902L;

//	@Transient
//	@Autowired
//	private transient UserRepository userRepository;

	@Id
	@Column(name = "id", nullable = false, length = 20)
	private String id;

	@Column(name = "password", nullable = false, length = 30)
	private String password;

	@Column(name = "name", nullable = false, length = 10)
	private String name;

	@Column(name = "introduce", nullable = false)
	private String introduce;

	@Column(name = "image", nullable = false, length = 100)
	private String profileImage;

	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "following", joinColumns = { @JoinColumn(name = "user") }, inverseJoinColumns = { @JoinColumn(name = "following") })
	private Set<User> followingUser = new HashSet<>();

	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "following", joinColumns = { @JoinColumn(name = "following") }, inverseJoinColumns = { @JoinColumn(name = "user") })
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

	public String getProfileImage() {
		return profileImage;
	}

	public void setProfileImage(String profileImage) {
		this.profileImage = profileImage;
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

//	public void setUserRepository(UserRepository repository) {
//		this.userRepository = repository;
//	}
//	
//	public User findUserById(String id) {
//		return userRepository.selectUserById(id);
//	}

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