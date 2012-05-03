package kr.ac.jejunu.rabbit.model;

public class User {
	private String Id;
	private String Name;
	private String Password;

	public User(String id, String name, String pass) {

		this.Id = id;
		this.Name = name;
		this.Password = pass;
	}

	public String getId() {
		return Id;
	}

	public String getName() {
		return Name;
	}

	public String getPassword() {
		return Password;
	}

}
