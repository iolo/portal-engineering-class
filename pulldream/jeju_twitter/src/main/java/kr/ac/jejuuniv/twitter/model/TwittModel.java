package kr.ac.jejuuniv.twitter.model;

public class TwittModel {
	private int twittnum;
	private String id;
	private String content;
	private String write_date;
	
	public int getArtid() {
		return twittnum;
	}
	public void setArtid(int artid) {
		this.twittnum = artid;
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
	public String getWritedate() {
		return write_date;
	}
	public void setWritedate(String writedate) {
		this.write_date = writedate;
	}
	
}
