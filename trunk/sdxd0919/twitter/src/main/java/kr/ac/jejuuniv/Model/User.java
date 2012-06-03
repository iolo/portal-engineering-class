package kr.ac.jejuuniv.Model;

public class User {
	private int userNum;
	private String id;
	private String password;
	private String name;
	private String description;
	private String profileImg;
	
	public User(){
	}
	
	public User(int userNum, String id, String password, String name) {
		this.userNum = userNum;
		this.id = id;
		this.password = password;
		this.name = name;
	}
	public int getUserNum() {
		return userNum;
	}
	public String getId() {
		return id;
	}
	public String getPassword() {
		return password;
	}
	public String getName() {
		return name;
	}
	public String getDescription() {
		return description;
	}
	public String getProfileImg() {
		return profileImg;
	}
	public void setUserNum(int userNum) {
		this.userNum = userNum;
	}
	public void setId(String id) {
		this.id = id;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public void setProfileImg(String profileImg) {
		this.profileImg = profileImg;
	}
	
	public String toString() {
		return "User [num= "+ userNum + ", id=" + id + ", name=" + name + ", password=" + password + "]";
	}

}
