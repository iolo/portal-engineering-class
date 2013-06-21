package kr.bong.replyboard.model;

import org.springframework.web.multipart.MultipartFile;

public class User {
	private String id;
	private String name;
	private String password;
	private String description;
	private String profPath;
	private MultipartFile profFile;

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

	public MultipartFile getProfFile() {
		return profFile;
	}

	public void setProfFile(MultipartFile profFile) {
		this.profFile = profFile;
	}

}
