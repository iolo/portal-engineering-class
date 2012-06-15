package kr.ac.jejuuniv.model;


public class UserModel
{
	private String id;
	private String password;
	private String name;
	private String explain;
	private String image;
	
	public UserModel(String id, String password, String name, String explain, String image)
	{
		this.setId(id);
		this.setPassword(password);
		this.setName(name);
		this.setExplain(explain);
		this.setImage(image);
	}
	
	public UserModel()
	{
		
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
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

	
}



