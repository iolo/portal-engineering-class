package kr.ac.jejunu.kdi.model;

public class User {
	private String Id;
	private String Name;
	private String Passwrod;
	

	public User(String Id, String Name, String Password) {
		this.setId(Id);
		this.setId(Name);
		this.setId(Password);
	}
	
	
	public String getId() {
		return Id;
	}
	public void setId(String id) {
		this.Id = id;
	}
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public String getPasswrod() {
		return Passwrod;
	}
	public void setPasswrod(String passwrod) {
		Passwrod = passwrod;
	}
}
