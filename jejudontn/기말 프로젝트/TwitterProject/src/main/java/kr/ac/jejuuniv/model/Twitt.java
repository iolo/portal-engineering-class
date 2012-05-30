package kr.ac.jejuuniv.model;

import org.apache.ibatis.type.Alias;

@Alias("Twitt")
public class Twitt {

	private String twiitID;
	private String id;
	private String writrDate;
	private String name;
	private String profilImageURI;
	private String twiitt;
	
	
	public String getTwiitID() {
		return twiitID;
	}
	public void setTwiitID(String twiitID) {
		this.twiitID = twiitID;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getWritrDate() {
		return writrDate;
	}
	public void setWritrDate(String writrDate) {
		this.writrDate = writrDate;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getProfilImageURI() {
		return profilImageURI;
	}
	public void setProfilImageURI(String profilImageURI) {
		this.profilImageURI = profilImageURI;
	}
	
	public String getTwiitt() {
		return twiitt;
	}
	public void setTwiitt(String twiitt) {
		this.twiitt = twiitt;
	}
	

	
}
