package kr.ac.jejunu.kdi.model;

public class User {
	private String id;
	private String password;
	private String name;
	private String memo;
	private String image;
	

	public User(String id, String password, String name, String memo, String image) {
		this.setId(id);
		this.setPassword(password);
		this.setName(name);
		this.setMemo(memo);
		this.setImage(image);
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

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getMemo() {
		return memo;
	}

	public void setMemo(String memo) {
		this.memo = memo;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}
	
	
	

}
