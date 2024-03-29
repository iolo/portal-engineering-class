package kr.ac.jejuuniv.service;

import java.io.File;

import kr.ac.jejuuniv.mapper.JoinMapper;
import kr.ac.jejuuniv.model.UserModel;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class JoinServiceImpl implements JoinService {
	
	@Autowired
	JoinMapper joinMapper;
	
	
	@Override
	public String saveFile(MultipartFile image) {

		String imageURI;
		imageURI = image.getOriginalFilename();
	
		File f = new File("/Users/iclab/Desktop/JinSNS/src/main/webapp/resources/image/"+ imageURI);
		try {
			image.transferTo(f); 
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return imageURI;
	}
	
	@Override
	public void joinUser(String id, String password, String name, String explain, MultipartFile image){

		UserModel user=new UserModel(id, password, name, explain, this.saveFile(image));
		joinMapper.joinUser(user);		
	}

	@Override
	public void UpdateUser(String id, String password, String name, String explain, MultipartFile image) {
		
		UserModel user=new UserModel(id, password, name, explain, this.saveFile(image));
		System.out.println(user.getId());
		joinMapper.updateUser(user);
		
	}


}
