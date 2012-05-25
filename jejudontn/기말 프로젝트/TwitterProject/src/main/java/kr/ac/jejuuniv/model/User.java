package kr.ac.jejuuniv.model;

import org.apache.ibatis.type.Alias;

@Alias("User")
public class User {

	private String password;
	private String name;
	private String id;
	private String information;
	private String profileImageUri;

	public User(String id, String password, String name, String infomation, String profileImageUri) {

		this.setId(id);
		this.setName(name);
		this.setPassword(password);
		this.setProfileImageUri(profileImageUri);
		this.setInformation(infomation);

	}

	public User() {

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

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getProfileImageUri() {
		return profileImageUri;
	}

	public void setProfileImageUri(String profileImageUri) {
		this.profileImageUri = profileImageUri;
	}

	public String getInformation() {
		return information;
	}

	public void setInformation(String information) {
		this.information = information;
	}

}
