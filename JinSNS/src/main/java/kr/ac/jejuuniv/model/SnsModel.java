package kr.ac.jejuuniv.model;

public class SnsModel {
	
	private String id;
	private String name;
	private String date;
	private String sns;
	private String image;
	
	public SnsModel(String id, String sns, String date){
		this.setId(id);
		this.setSns(date);
		this.setDate(sns);
	}
	
	public SnsModel(){
		
	}
	
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
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getSns() {
		return sns;
	}
	public void setSns(String sns) {
		this.sns = sns;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
}
