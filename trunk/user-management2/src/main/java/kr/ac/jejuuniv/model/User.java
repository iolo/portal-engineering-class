package kr.ac.jejuuniv.model;

public class User {

	private String id;
	private String name;
	private Object password;

	public User(String id, String name, String password) {
		this.setId(id);
		this.setName(name);
		this.setPassword(password);
	}

	public User() {
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Object getPassword() {
		return password;
	}

	public void setPassword(Object password) {
		this.password = password;
	}
}
