package kr.ac.jejuuniv.Controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import javax.servlet.http.HttpSession;

import kr.ac.jejuuniv.Model.User;
import kr.ac.jejuuniv.Service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class ProfileController {
	@Autowired
	private UserService userService;

	@RequestMapping("/service/profile")
	public User action(HttpSession session, User newUser){
		int userNum = (Integer) session.getAttribute("userNum");

		return userService.getUser(userNum);
	}
	
	@RequestMapping(value = "/service/profileSave", method=RequestMethod.POST)
	public String save(HttpSession session, User user, @RequestParam("file") MultipartFile file) throws IOException{
		String name = file.getOriginalFilename(); 
		if(!name.equals("")){
			String imagePath = uploadFile(file, user.getId(), name);
			user.setProfileImg(imagePath);
		}
		System.out.println(user.toString() +" d = " + user.getDescription() + " i  = " + user.getProfileImg());
		userService.update(user);
		
		return "redirect:/service/personalSNS";
	}

	private String uploadFile(MultipartFile file, String userId, String name) throws IOException{
		byte[] byteFile = file.getBytes();
		
		String path = "/Users/HSY/Documents/workspace-sts-2.9.0.RELEASE/workspace/PortalService/twitter/src/main/webapp/resources";
		path = path + "/" + userId + "/";
		
		File dirPaht = new File(path);
		if(!dirPaht.exists()){
			dirPaht.mkdir();
		}
		
		File uploadedFile = new File(path + name);
		FileOutputStream fos;
		fos = new FileOutputStream(uploadedFile);
		fos.write(byteFile);
		fos.close();

		String imagePath = "/twitter/resources/" + userId + "/" + name;
		return imagePath;
	}
}
