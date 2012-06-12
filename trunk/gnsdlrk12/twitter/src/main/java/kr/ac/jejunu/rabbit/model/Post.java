package kr.ac.jejunu.rabbit.model;

public class Post {
	
	private String image;
	private int post_num;
	private String postid;
	private String name;
	private String content;
	private String regdate;
	
	public int getPost_num() {
		return post_num;
	}
	public void setPost_num(int postnum) {
		this.post_num = postnum;
	}
	public String getPostid() {
		return postid;
	}
	public void setPostid(String postid) {
		this.postid = postid;
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
