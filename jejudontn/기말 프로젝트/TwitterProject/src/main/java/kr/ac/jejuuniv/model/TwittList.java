package kr.ac.jejuuniv.model;

import org.apache.ibatis.type.Alias;

@Alias("TwittList")
public class TwittList {
	private String imageURI;
	private String name;
	private String writeDate;
	private String twiitNumber;
	private String twiitText;
	
	
	
	public String getWriteDate() {
		return writeDate;
	}
	public void setWriteDate(String writeDate) {
		this.writeDate = writeDate;
	}
	public String getTwiitNumber() {
		return twiitNumber;
	}
	public void setTwiitNumber(String twiitNumber) {
		this.twiitNumber = twiitNumber;
	}
	public String getTwiitText() {
		return twiitText;
	}
	public void setTwiitText(String twiitText) {
		this.twiitText = twiitText;
	}
	public String getImageURI() {
		return imageURI;
	}
	public void setImageURI(String imageURI) {
		this.imageURI = imageURI;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
}
