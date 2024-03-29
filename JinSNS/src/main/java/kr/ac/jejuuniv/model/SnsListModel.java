package kr.ac.jejuuniv.model;

public class SnsListModel {
	
	private String index;
	private String id;
	private String sns;
	private String date;
	private String name;
	private String image;


	public SnsListModel(String id, String index, String date, String sns,String name, String image) {
		this.setId(id);
		this.setDate(date);
		this.setIndex(index);
		this.setSns(sns);
		this.setName(name);
		this.setImage(image);
	}

	public SnsListModel() {

	}
	
	public String getIndex() {
		return index;
	}

	public void setIndex(String index) {
		this.index = index;
	}
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}


	public String getSns() {
		return sns;
	}

	public void setSns(String sns) {
		this.sns = sns;
	}
	
	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
