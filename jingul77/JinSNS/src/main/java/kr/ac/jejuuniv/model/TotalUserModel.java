package kr.ac.jejuuniv.model;

public class TotalUserModel
{
	private String id;
	private String name;
	private String explain;
	private String image;
	private String follow;
	
	public TotalUserModel(String id, String name, String explain, String image,String follow)
	{
		this.setId(id);
		this.setName(name);
		this.setExplain(explain);
		this.setImage(image);
		this.setFollow(follow);
	}
	
	public TotalUserModel()
	{
		
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
	public String getExplain() {
		return explain;
	}
	public void setExplain(String explain) {
		this.explain = explain;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}
	public String getFollow() {
		return follow;
	}
	public void setFollow(String follow) {
		this.follow = follow;
	}

	
}



