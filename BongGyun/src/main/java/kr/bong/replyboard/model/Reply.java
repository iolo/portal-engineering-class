package kr.bong.replyboard.model;

import java.util.Date;

public class Reply {
	private int replyNo;
	private String id;
	private String name;
	private String profPath;
	private String content;
	private Date regiDate;
	private String strRegiDate;
	private int upCount;
	private int downCount;

	public int getReplyNo() {
		return replyNo;
	}

	public void setReplyNo(int replyNo) {
		this.replyNo = replyNo;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Date getRegiDate() {
		return regiDate;
	}

	public void setRegiDate(Date regiDate) {
		this.regiDate = regiDate;
	}

	public int getUpCount() {
		return upCount;
	}

	public void setUpCount(int upCount) {
		this.upCount = upCount;
	}

	public int getDownCount() {
		return downCount;
	}

	public void setDownCount(int downCount) {
		this.downCount = downCount;
	}

	public String getStrRegiDate() {
		return strRegiDate;
	}

	public void setStrRegiDate(String strRegiDate) {
		this.strRegiDate = strRegiDate;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getProfPath() {
		return profPath;
	}

	public void setProfPath(String profPath) {
		this.profPath = profPath;
	}
}
