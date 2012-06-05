package kr.ac.jejuuniv.service;

import java.util.List;

import kr.ac.jejuuniv.model.AllFollow;
import kr.ac.jejuuniv.model.AllUsers;

import org.springframework.web.multipart.MultipartFile;

public interface ServiceUtility {

	String getTime();
	
	public boolean validationImageExt(String filename);
	
	public String inputFile(MultipartFile profileImage);

	void setFollow(List<AllUsers> allUsers, List<AllFollow> allFollows);

}
