package kr.ac.jejuuniv.model.user;

import java.io.*;
import java.util.ArrayList;
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

	public List<User> findAllUserNotExistMe() {
		return userMapper.selectAllUserNotExistId(getId());
	}

	public void followUserById(String targetId) {
		if (targetId.equals(getId())) {
			throw new NotFollowingException("같은 아이디 끼리는 Follow가 되지 않습니다.");
		}

		checkUserExsist(targetId, "Follow 하려는 User " + targetId
				+ " (이)가 존재하지 않습니다");

		if(followingMapper.countFollowing(getId(), targetId) == 1) {
			throw new NotFollowingException(getId() + " 와 " + targetId
					+ " (은)는 Follow 이미 Following 관계 입니다.");
		}

		followingMapper.insertFollowing(getId(), targetId);
	}

	public void unFollowUserById(String targetId) {
		if (targetId.equals(getId())) {
			throw new NotUnFollowingException("같은 아이디 끼리는 Unfollow가 되지 않습니다.");
		}

		checkUserExsist(targetId, "UnFollow 하려는 User " + targetId
				+ " (이)가 존재하지 않습니다");

		if(followingMapper.countFollowing(getId(), targetId) == 0) {
			throw new NotUnFollowingException(getId() + " 와 " + targetId
					+ " (은)는 Following 관계가 아닙니다.");
		}
		

		followingMapper.deleteFollowing(getId(), targetId);
	}

	private void checkUserExsist(String targetId, String message) {
		if (userMapper.selectUserById(targetId) == null) {
			throw new NotFoundUserException(message);
		}
		if(userMapper.selectUserById(getId()) == null) {
			throw new NotFoundUserException("User " + getId() + "(이)가 존재하지 않습니다.");
		}
	}

	public List<User> followingUserList() {
		return userMapper.selectAllFollowingUser(getId());
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

	public List<UserRow> markFollowUser(List<User> userList) {
		if (userMapper.selectUserById(getId()) == null) {
			throw new NotFoundUserException("User " + getId()
					+ " (을)를 찾을 수 없습니다.");
		}

		List<User> following = followingUserList();
		List<UserRow> item = new ArrayList<>();
		for (User user : userList) {
			UserRow row = new UserRow(user, false);

			for (User user2 : following) {
				if (user.getId().equals(user2.getId())) {
					row.setFollowing(true);
				}
			}

			item.add(row);
		}

		return item;
	}

	public List<User> followerUserList() {
		return userMapper.selectAllFollowerUser(getId());
	}

	public String toString() {
		return "User [id=" + id + "]";
	}
}