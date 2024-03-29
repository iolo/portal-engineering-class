package kr.ac.jejuuniv.twitter.model;

import org.apache.ibatis.type.Alias;

@Alias("Twitt")
public class TwittModel {
	private int twinum;
	private String id;
	private String name;
	private String content;
	private String write_date;
	
	public int getTwinum() {
		return twinum;
	}
	public void setTwinum(int twinum) {
		this.twinum = twinum;
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
	public String getWrite_date() {
		return write_date;
	}
	public void setWrite_date(String write_date) {
		this.write_date = write_date;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
}
