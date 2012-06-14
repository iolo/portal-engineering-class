package kr.ac.jejuuniv.model;

import java.io.Serializable;
import java.sql.Timestamp;

import org.apache.ibatis.type.Alias;

@Alias("Post")
public class Post implements Serializable{
	private static final long serialVersionUID = -5370382390788416828L;
	
	private String userId;
	private int sequenceNumber;
	private String content;
	private Timestamp writeDate;
	private String userName;
	private String photo;
	
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPhoto() {
		return photo;
	}
	public void setPhoto(String photo) {
		this.photo = photo;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public int getSequenceNumber() {
		return sequenceNumber;
	}
	public void setSequenceNumber(int sequenceNumber) {
		this.sequenceNumber = sequenceNumber;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public Timestamp getWriteDate() {
		return writeDate;
	}
	public void setWriteDate(Timestamp writeDate) {
		this.writeDate = writeDate;
	}
	

}
