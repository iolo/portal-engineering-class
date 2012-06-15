package kr.ac.jejunu.rabbit.contoller;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import kr.ac.jejunu.rabbit.model.User;
import kr.ac.jejunu.rabbit.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;

@Controller
@RequestMapping("/userjoin")
public class UserJoinController {
	@Autowired
	UserService userService;
	
	@RequestMapping(method = RequestMethod.POST)
	public String userReg(User user, MultipartFile userimage) throws FileNotFoundException, IOException{
		saveImage(user, userimage);
		userService.UserInsert(user);
		return "finish";		
	}
	
	public void saveImage(User user, MultipartFile image) throws IOException, FileNotFoundException {
		String fileType = getFileType(image);
		File imageFile = new File("/Users/jeongjaehun/Documents/springworkspace/.metadata/.plugins/org.eclipse.wst.server.core/tmp0/wtpwebapps/twitter/resources/"
				+ user.getUserid() + fileType);
		if (imageFile.exists()) {
			imageFile.delete();
		}
		imageFile.createNewFile();

		FileOutputStream fos = new FileOutputStream(imageFile);
		fos.write(image.getBytes());
		fos.close();
		
		if(image == null || image.isEmpty()){
			user.setImage("nullRegImage" + fileType);
		}
		else{
			user.setImage(user.getUserid() + fileType);
		}
		
	}
	
	private String getFileType(MultipartFile image) {
		String file = null;
		if(image.getContentType().equals("image/jpg") || image.getContentType().equals("image/jpeg")){		
			file = ".jpg";
		}
		else if (image.getContentType().equals("image/gif")) {
			file = ".gif";
		}
		else if (image.getContentType().equals("image/png")) {
			file = ".png";
		}
		else{
			file = ".jpg";
		}
		return file;
	}
}
