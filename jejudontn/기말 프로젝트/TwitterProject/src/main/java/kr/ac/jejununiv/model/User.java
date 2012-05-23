package kr.ac.jejununiv.model;

public class User {

	private String password;
	private String name;
	private String id;

	public User(String id, String name, String password) {

		this.setId(id);
		this.setName(name);
		this.setPassword(password);

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

}
