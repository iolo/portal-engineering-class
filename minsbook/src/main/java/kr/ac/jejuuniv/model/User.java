package kr.ac.jejuuniv.model;

import org.springframework.web.multipart.MultipartFile;

public class User {
	private String id;
	private String password;
	private String name;
	private String nickName;
	private String profileImgPath;

	/**
	 * 
	 * @param id
	 * @param password
	 * @param name
	 * @param nickName
	 * @param profileImgPath
	 */
	public User(String id, String password, String name, String nickName,
			String profileImgPath) {
		this.id = id;
		this.password = password;
		this.name = name;
		this.nickName = nickName;
		this.profileImgPath = profileImgPath;
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

	public String getNickname() {
		return nickName;
	}

	public void setNickname(String nickname) {
		this.nickName = nickname;
	}

	public String getProfileImgPath() {
		return profileImgPath;
	}

	public void setProfileImgPath(String profileImgPath) {
		this.profileImgPath = profileImgPath;
	}


}
