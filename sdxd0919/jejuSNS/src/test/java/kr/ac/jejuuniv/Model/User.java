package kr.ac.jejuuniv.Model;

public class User {
	String id;
	String password;
	
	public User(String id, String password) {
		this.id = id;
		this.password = password;
	}
	public String getId() {
		return id;
	}
	public String getPassword() {
		return password;
	}
	public void setId(String id) {
		this.id = id;
	}
	public void setPassword(String password) {
		this.password = password;
	}


}


