package kr.ac.jejuuniv.model;

import org.apache.ibatis.type.Alias;

@Alias("User")
public class User {

	private String password;
	private String name;
	private String id;
	private String information;
	private String imageURI;

	public User(String id, String password, String name, String infomation, String imageURI) {

		this.setId(id);
		this.setName(name);
		this.setPassword(password);
		this.setimageURI(imageURI);
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

	public String getInformation() {
		return information;
	}

	public void setInformation(String information) {
		this.information = information;
	}

	public String getimageURI() {
		return imageURI;
	}

	public void setimageURI(String imageURI) {
		this.imageURI = imageURI;
	}

}
