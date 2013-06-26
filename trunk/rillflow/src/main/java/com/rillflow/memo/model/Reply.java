package com.rillflow.memo.model;

import java.util.Date;

public class Reply {

	private int no;
	private User user;
	private String contents;
	private Date insertDate;

	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}

	public String getId() {
		return user.getId();
	}
	public void setId(String id) {
		this.user.setId(id);
	}

	public String getName() {
		return user.getName();
	}
	public void setName(String name) {
		this.user.setName(name);
	}

	public String getImagePath() {
		return user.getImagePath();
	}
	public void setImagePath(String imagePath) {
		this.user.setImagePath(imagePath);
	}
	
	public String getContents() {
		return contents;
	}
	public void setContent(String contents) {
		this.contents = contents;
	}

	public Date getInsertDate() {
		return insertDate;
	}
	public void setInsertDate(Date insertDate) {
		this.insertDate = insertDate;
	}
}
