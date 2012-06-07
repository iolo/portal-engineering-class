package jnu.ce.bs.k.model;

public class User {
	private String member_num;
	private String id;
	private String password;
	private String name;
	private String description;
	private String profile;

	public User(String id, String password, String name, String description, String profile) {

		this.setId(id);
		this.setName(name);
		this.setPassword(password);
		this.setDescription(description);
		this.setProfile(profile);

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

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getProfile() {
		return profile;
	}

	public void setProfile(String profile) {
		this.profile = profile;
	}

	public String getUserNum() {
		return member_num;
	}

	public void setUserNum(String userNum) {
		this.member_num = userNum;
	}

}
