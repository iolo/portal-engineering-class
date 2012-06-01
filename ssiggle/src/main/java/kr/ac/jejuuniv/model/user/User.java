package kr.ac.jejuuniv.model.user;

import java.io.*;
import java.util.List;
import java.util.Set;

import kr.ac.jejuuniv.mapper.UserMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.web.multipart.MultipartFile;

//TODO : User user = new UserImpl() 이런거 어떨까? 괜히 코드만 어렵게 만드는거 아닌가?
@Configurable
public class User implements UserTransaction, Serializable {
	private static final long serialVersionUID = 1584661762891063902L;

	@Autowired
	private UserMapper userMapper;

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

	public Set<User> getFallowerUser() {
		return null;
	}

	public void setFollowerUser(Set<UserTransaction> followerUser) {
	}

	public boolean loginVaid(String id, String password) {
		User user = userMapper.selectUserById(id);

		if (user == null || !user.getPassword().equals(password)) {
			return false;
		}

		return true;
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
	public User findUserById(String loginId) {
		UserTransaction user = userMapper.selectUserById(loginId);
		if (user == null) {
			throw new NotFoundUserException("찾으시는 User " + id
					+ " (은)는 존재하지 않습니다");
		}

		return userMapper.selectUserById(loginId);
	}

	@Override
	public List<User> findAllUser() {
		return userMapper.selectAllUser();
	}

	// TODO : 이 아래 4개의 메소드에 대해 테스트 작성하기.실패테스트, 현재 User의 id 값이 null 일때 시도 , 등록되지
	// 않은 User 임에도 시도. 잠만,.. 이거 둘이 엮을 수 있지 않나?
	@Override
	public void followUserById(String targetId) {
		throw new NotFoundUserException("Follow 하려는 User " + targetId
				+ " (이)가 존재하지 않습니다");
	}

	@Override
	public void unFollowUserById(String targetId) {

	}

	@Override
	public List<User> followingUserList() {
		return null;
	}

	@Override
	public List<User> followUserList() {
		return null;
	}

	@Override
	public String toString() {
		return "User [id=" + id + "]";
	}

	// TODO : 이 부분을 유틸리티 메소드 UserUtil.saveImage()로 빼는 것은 어떨까? 애초에 여기 넣는게 맞는가?
	public void saveImage(MultipartFile file) throws IOException,
			FileNotFoundException {
		String fileType = getFileType(file);

		byte[] byteFile = file.getBytes();
		File uploadedFile = new File(
				"/home/sens/stsWorkspace/.metadata/.plugins/org.eclipse.wst.server.core/tmp1/wtpwebapps/ssiggle/resources/userimage/"
						+ getId() + fileType);

		if (uploadedFile.exists()) {
			uploadedFile.delete();
		}

		uploadedFile.createNewFile();

		FileOutputStream fos;
		fos = new FileOutputStream(uploadedFile);
		fos.write(byteFile);
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
}