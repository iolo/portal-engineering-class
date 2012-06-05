package kr.ac.jejuuniv.service;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import kr.ac.jejuuniv.model.AllFollow;
import kr.ac.jejuuniv.model.AllUsers;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class ServiceUtilityImplement implements ServiceUtility {

	@Override
	public String getTime() {
		SimpleDateFormat mSimpleDateFormat = new SimpleDateFormat("yyyy.MM.dd",
				Locale.KOREA);
		Date currentTime = new Date();
		return mSimpleDateFormat.format(currentTime);
	}
	
	@Override
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
	
	@Override
	public String inputFile(MultipartFile profileImage) {

		String fileURI;

		if (profileImage.getOriginalFilename().isEmpty()) {
			fileURI = "default.png";
		} else {
			fileURI = System.currentTimeMillis()
					+ profileImage.getOriginalFilename();
		}

		File f = new File(
				"C:\\Users\\daeheon\\Desktop\\4학년1학기\\포털서비스개발방법론\\source\\TwitterProject\\src\\main\\webapp\\resources\\ProfileImage\\"
						+ fileURI); // File : java.io.file
		try {
			profileImage.transferTo(f); // transferTo() 메소드를 사용하면 지정한 경로에
										// 저장이 완료
		} catch (Exception e) {
			e.printStackTrace();
		}

		return fileURI;
	}
	
	@Override
	public void setFollow(List<AllUsers> allUsers, List<AllFollow> allFollows) {

		for (AllUsers alluser : allUsers) {
			alluser.setFollow("Follow");
		}
		if (!allFollows.isEmpty()) {
			for (AllUsers alluser : allUsers) {
				for (AllFollow allFollower : allFollows) {
					if (alluser.getId().equals(allFollower.getFollowing())) {
						alluser.setFollow("UnFollow");
					}
				}
			}
		}

	}

}
