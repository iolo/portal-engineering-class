package kr.ac.jejuuniv.model.user;

import java.io.*;
import java.util.List;

import kr.ac.jejuuniv.mapper.FollowingMapper;
import kr.ac.jejuuniv.mapper.UserMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.web.multipart.MultipartFile;

@Configurable
public class User implements Serializable {
	private static final long serialVersionUID = 1584661762891063902L;

	@Autowired
	private UserMapper userMapper;
	@Autowired
	private FollowingMapper followingMapper;

	private String id;
	private String password;
	private String name;
	private String introduce;
	private String image = "DefaultUserImage.jpg";

	public User() {
	}

	public User(UserMapper userMapper) {
		this.userMapper = userMapper;
	}

	public UserMapper getUserMapper() {
		return userMapper;
	}

	public void setUserMapper(UserMapper userMapper) {
		this.userMapper = userMapper;
	}

	public void setFollowMapper(FollowingMapper followMapper) {
		this.followingMapper = followMapper;
	}

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

	public boolean loginValid(String id, String password) {
		User user = userMapper.selectUserById(id);

		if (user == null || !user.getPassword().equals(password)) {
			return false;
		}

		return true;
	}

	public void save() {
		if (userMapper.selectUserById(this.getId()) == null) {
			userMapper.insertUser(this);
		} else {
			userMapper.updateUser(this);
		}
	}

	public User findUserById(String loginId) {
		User user = userMapper.selectUserById(loginId);
		if (user == null) {
			throw new NotFoundUserException("찾으시는 User " + id
					+ " (은)는 존재하지 않습니다");
		}

		return userMapper.selectUserById(loginId);
	}

	public List<User> findAllUser() {
		return userMapper.selectAllUser();
	}

	// TODO : 이 아래 4개의 메소드에 대해 테스트 작성하기.실패테스트, 현재 User의 id 값이 null 일때 시도 , 등록되지
	// 않은 User 임에도 시도. 잠만,.. 이거 둘이 엮을 수 있지 않나?
	public void followingUserById(String targetId) {
		if (userMapper.selectUserById(targetId) == null
				|| userMapper.selectUserById(getId()) == null) {
			throw new NotFoundUserException("Follow 하려는 User " + targetId
					+ " (이)가 존재하지 않습니다");
		}

		checkFollowUser(targetId, true, getId() + " 와 " + targetId
				+ " (은)는 Follow 이미 Following 관계 입니다.");

		followingMapper.insertFollowing(getId(), targetId);
	}

	public void unFollowUserById(String targetId) {
		if (userMapper.selectUserById(targetId) == null
				|| userMapper.selectUserById(getId()) == null) {
			throw new NotFoundUserException("Follow 하려는 User " + targetId
					+ " (이)가 존재하지 않습니다");
		}

		checkFollowUser(targetId, false, getId() + " 와 " + targetId
				+ " (은)는 Follow 관계가 아닙니다.");

		followingMapper.deleteFollowing(getId(), targetId);
	}

	private void checkFollowUser(String targetId, boolean flag, String s) {
		int checkValue = (flag) ? 1 : 0;

		if (followingMapper.countFollowing(getId(), targetId) == checkValue) {
			throw new NotFollowingException(s);
		}
	}

	public List<User> followingUserList() {
		return null;
	}

	public List<User> followUserList() {
		return userMapper.selectAllFollowingUser(getId());
	}

	public String toString() {
		return "User [id=" + id + "]";
	}

	public void saveImage(MultipartFile file) throws IOException,
			FileNotFoundException {
		String fileType = getFileType(file);

		File uploadedFile = new File(
				"/home/sens/stsWorkspace/.metadata/.plugins/org.eclipse.wst.server.core/tmp1/wtpwebapps/ssiggle/resources/userimage/"
						+ getId() + fileType);

		if (uploadedFile.exists()) {
			uploadedFile.delete();
		}
		uploadedFile.createNewFile();

		FileOutputStream fos = new FileOutputStream(uploadedFile);
		fos.write(file.getBytes());
		fos.close();

		setImage(getId() + fileType);
	}

	private String getFileType(MultipartFile file) {
		switch (file.getContentType()) {
		case "image/jpg":
		case "image/jpeg":
			return ".jpg";
		case "image/gif":
			return ".gif";
		case "image/png":
			return ".png";
		}

		return "";
	}

	public List<User> followerUserList() {
		return userMapper.selectAllFollowerUser(getId());
	}
}