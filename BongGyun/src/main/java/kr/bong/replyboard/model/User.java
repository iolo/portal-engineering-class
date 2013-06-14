package kr.bong.replyboard.model;

public class User {
	private String id;
	private String name;
	private String password;
	private String description;
	private String profPath;

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

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getProfPath() {
		return profPath;
	}

	public void setProfPath(String profPath) {
		this.profPath = profPath;
	}

}
