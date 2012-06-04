package kr.ac.jejuuniv.service;

import org.springframework.web.multipart.MultipartFile;

public interface ServiceUtility {

	String getTime();
	
	public boolean validationImageExt(String filename);
	
	public String inputFile(MultipartFile profileImage);

}
