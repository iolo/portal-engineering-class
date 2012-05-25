package kr.ac.jejuuniv.service;

import java.io.File;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class UserServiceImplement implements UserService {

	@Override
	public void createUser(String id, String password, String name,
			String information, MultipartFile profileImage) {
		String fileURI = "C:\\Users\\daeheon\\Desktop\\4학년1학기\\포털서비스개발방법론\\source\\TwitterProject\\ProfileImageFolder\\" +  System.currentTimeMillis()+profileImage.getOriginalFilename() ; 

		if (validationImageExt(profileImage.getOriginalFilename())) {
			File f = new File(fileURI);                // File : java.io.file
			try {
				profileImage.transferTo(f);                // transferTo() 메소드를 사용하면 지정한 경로에 저장이 완료
			} catch (Exception e) {
			    e.printStackTrace();
			}
			// DB에 넣을부분(id, password, name, information, 파일 이름
			
		}

	}

	public boolean validationImageExt(String filename) {

		String imgExt = filename.substring(filename.lastIndexOf(".") + 1,
				filename.length());

		if (imgExt.equalsIgnoreCase("JPG") || imgExt.equalsIgnoreCase("JPEG")
				|| imgExt.equalsIgnoreCase("GIF")
				|| imgExt.equalsIgnoreCase("PNG")
				|| imgExt.equalsIgnoreCase("")) {
			return true;
		} else {
			return false;
		}
	}
}
