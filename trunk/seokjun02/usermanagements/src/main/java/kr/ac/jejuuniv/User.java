package kr.ac.jejuuniv;

import org.apache.ibatis.type.Alias;

@Alias("User")
public class User {
	private String id;
	private String name;
	private String password;
	public User(String id, String name, String password) {
		this.setId(id);
		this.setName(name);
		this.setPassword(password);
	}
	public User(){
		
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
