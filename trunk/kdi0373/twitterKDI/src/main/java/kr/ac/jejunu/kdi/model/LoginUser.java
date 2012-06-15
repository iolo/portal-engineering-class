package kr.ac.jejunu.kdi.model;


public class LoginUser {
	private String id;
	private String password;

	public LoginUser(String id, String password){
		this.setId(id);
		this.setPassword(password);
	}
	public LoginUser(){

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

}
