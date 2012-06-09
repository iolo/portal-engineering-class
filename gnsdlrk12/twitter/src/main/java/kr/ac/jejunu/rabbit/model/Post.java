package kr.ac.jejunu.rabbit.model;

public class Post {
	
	private String image;
	private String post_num;
	private String userid;
	private String name;
	private String content;
	private String regdate;
	
	public String getPost_num() {
		return post_num;
	}
	public void setPost_num(String post_num) {
		this.post_num = post_num;
	}
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getRegdate() {
		return regdate;
	}
	public void setRegdate(String regdate) {
		this.regdate = regdate;
	}
	
	@Override
	public String toString() {
		return "User [image=" + image + ", name=" + getName() + ", content=" + content + ", regdate=" + regdate + "]";
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
}
