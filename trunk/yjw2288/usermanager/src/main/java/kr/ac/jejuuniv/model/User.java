package kr.ac.jejuuniv.model;

import java.io.Serializable;

public class User implements Serializable {
	private static final long serialVersionUID = 2089920943650145055L;

	private String id;
	private String name;
	private String password;

	public User() {
	}

	public User(String id, String name, String password) {
		setId(id);
		setName(name);
		setPassword(password);
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

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}