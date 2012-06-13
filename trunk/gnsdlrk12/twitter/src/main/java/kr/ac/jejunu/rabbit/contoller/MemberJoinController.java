package kr.ac.jejunu.rabbit.contoller;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import kr.ac.jejunu.rabbit.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

@Controller
@RequestMapping("/join")
public class MemberJoinController {
	@Autowired
	UserService userService;
	
	@RequestMapping
	public String memberjoin(){
		System.out.println(359834534);
		return "memberJoin";
	}
	
//	public void saveImage(MultipartFile file) throws IOException, FileNotFoundException {String fileType = getFileType(file);
//
//File uploadedFile = new File(
//		"/home/sens/stsWorkspace/.metadata/.plugins/org.eclipse.wst.server.core/tmp1/wtpwebapps/ssiggle/resources/userimage/"
//				+ getId() + fileType);
//
//if (uploadedFile.exists()) {
//	uploadedFile.delete();
//}
//uploadedFile.createNewFile();
//
//FileOutputStream fos = new FileOutputStream(uploadedFile);
//fos.write(file.getBytes());
//fos.close();
//
//setImage(getId() + fileType);
//}
//
//private String getFileType(MultipartFile file) {
//switch (file.getContentType()) {
//case "image/jpg":
//case "image/jpeg":
//	return ".jpg";
//case "image/gif":
//	return ".gif";
//case "image/png":
//	return ".png";
//}
//
//return "";
//}
}
