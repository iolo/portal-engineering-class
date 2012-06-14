package kr.ac.jejuuniv.Controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import org.springframework.web.multipart.MultipartFile;


public class UploadFileData {

	public String uploadFile(MultipartFile file, String userId, String name) throws IOException{
		byte[] byteFile = file.getBytes();
		
		System.out.println("uploadfile!!!!!");
		
		String path = "/Users/HSY/Documents/workspace-sts-2.9.0.RELEASE/workspace/PortalService/new-twitter/src/main/webapp/resources/profileImg";
		path = path + "/" + userId + "/";
		
		System.out.println("path =  " + path);
		
		File dirPaht = new File(path);
		if(!dirPaht.exists()){
			System.out.println("path nono...");
			dirPaht.mkdir();
			System.out.println("dir make!");
		}

		File uploadedFile = new File(path + name);
		FileOutputStream fos;
		fos = new FileOutputStream(uploadedFile);
		fos.write(byteFile);
		fos.close();

		String imagePath = "/twitter/resources/profileImg/" + userId + "/" + name;
		System.out.println("fileupload  + imagepath = " + imagePath);
		return imagePath;
	}
}