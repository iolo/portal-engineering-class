package kr.ac.jejuuniv.service;

import org.springframework.web.multipart.MultipartFile;

public class UserServiceImplement implements UserService {

	@Override
	public void createUser(String id, String password, String name,
			String information, MultipartFile profileImage) {
		
		
		if(validationImageExt(profileImage)){
			// DB에 넣을부분
		}
		
		

	}
	
	public boolean validationImageExt(MultipartFile profileImage){
	
			if (!profileImage.isEmpty()) {
				String filename = profileImage.getOriginalFilename();
				String imgExt = filename.substring(filename.lastIndexOf(".") + 1,
						filename.length());

				if (imgExt.equalsIgnoreCase("JPG")
						|| imgExt.equalsIgnoreCase("JPEG")
						|| imgExt.equalsIgnoreCase("GIF")
						|| imgExt.equalsIgnoreCase("PNG")) {
					return true;
				} else {
					return false;
				}
			}
		return false;
	}


}
