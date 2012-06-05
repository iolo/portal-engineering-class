package kr.ac.jejuuniv.service;

import java.util.List;

import kr.ac.jejuuniv.model.AllFollow;
import kr.ac.jejuuniv.model.AllUsers;
import kr.ac.jejuuniv.model.FollowIdTemp;
import kr.ac.jejuuniv.model.User;
import kr.ac.jejuuniv.repository.UserMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class UserServiceImplement implements UserService {


	@Autowired
	UserMapper userMapper;
	@Autowired
	ServiceUtility serviceUtility;

	@Override
	public void createUser(String id, String password, String name,
			String information, MultipartFile profileImage) {
		
		if (serviceUtility.validationImageExt(profileImage.getOriginalFilename())) {
			String fileURI = serviceUtility.inputFile(profileImage);

			User user = new User(id, password, name, information, fileURI);
			userMapper.createUser(user);

		}

	}
	

	@Override
	public void modifyUser(String id, String password, String name,
			String information, MultipartFile profileImage) {

		if (serviceUtility.validationImageExt(profileImage.getOriginalFilename())) {
			
			String fileURI = serviceUtility.inputFile(profileImage);
			User user = new User(id, password, name, information, fileURI);
			userMapper.modifyUser(user);

		}

	}

	@Override
	public List<AllUsers> findAlluser(String id) {
		List<AllUsers> allUsers = userMapper.findAlluser(id);
		List<AllFollow> allFollows = userMapper.findAllFollow(id);
			
		serviceUtility.setFollow(allUsers, allFollows);

		return allUsers;
	}

	@Override
	public void FollowUser(String id, String follow, String followid) {
		FollowIdTemp followTemp = new FollowIdTemp(id, followid);
		
		if (follow.equals("Follow")) {
			userMapper.createFollow(followTemp);
		} else {
			userMapper.deleteFollow(followTemp);

		}

	}

}
