package kr.ac.jejuuniv.model;

public class TwitModel {
	private String id;
	private String writer;
	private String twit_text;
	private String date;	
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	public String getTwit_text() {
		return twit_text;
	}
	public void setTwit_text(String twit_text) {
		this.twit_text = twit_text;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}	
}
