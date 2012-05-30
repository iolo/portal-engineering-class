package kr.ac.jejuuniv.service;

import java.io.File;
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

	List<AllUsers> allUsers;
	List<AllFollow> allFollows;
	User user;

	@Autowired
	UserMapper userMapper;

	@Override
	public void createUser(String id, String password, String name,
			String information, MultipartFile profileImage) {

		String fileURI = System.currentTimeMillis() + profileImage.getOriginalFilename();
		if (validationImageExt(profileImage.getOriginalFilename())) {
			File f = new File("C:\\Users\\daeheon\\Desktop\\4학년1학기\\포털서비스개발방법론\\source\\TwitterProject\\src\\main\\webapp\\resources\\ProfileImage\\" + fileURI); // File : java.io.file
			try {
				profileImage.transferTo(f); // transferTo() 메소드를 사용하면 지정한 경로에
											// 저장이 완료
			} catch (Exception e) {
				e.printStackTrace();
			}
			// DB에 넣을부분(id, password, name, information, 파일 이름
			User user = new User(id, password, name, information, fileURI);

			userMapper.createUser(user);

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

	@Override
	public void modifyUser(String id, String password, String name,
			String information, MultipartFile profileImage) {

		String fileURI = System.currentTimeMillis() + profileImage.getOriginalFilename();
		if (validationImageExt(profileImage.getOriginalFilename())) {
			File f = new File("C:\\Users\\daeheon\\Desktop\\4학년1학기\\포털서비스개발방법론\\source\\TwitterProject\\src\\main\\webapp\\resources\\ProfileImage\\" + fileURI); // File : java.io.file
			try {
				profileImage.transferTo(f); // transferTo() 메소드를 사용하면 지정한 경로에
											// 저장이 완료
			} catch (Exception e) {
				e.printStackTrace();
			}
			User user = new User(id, password, name, information, fileURI);
			userMapper.modifyUser(user);

		}

	}

	@Override
	public List<AllUsers> findAlluser(String id) {
		allUsers = userMapper.findAlluser();
		allFollows = userMapper.findAllFollow(id);
		for (AllUsers alluser : allUsers) {
			if (!allFollows.isEmpty()) {
				for (AllFollow allFollower : allFollows) {
					if (alluser.getId().equals(allFollower.getFollowing())) {
						alluser.setFollow("UnFollow");
					} else {
						alluser.setFollow("Follow");
					}
				}
			} else {
				alluser.setFollow("Follow");
			}
		}

		return allUsers;
	}


	@Override
	public void Followluser(String id, String follow, String followid) {
		FollowIdTemp followTemp = new FollowIdTemp();
		followTemp.setUserId(id);
		followTemp.setFollowId(followid);
		if(follow.equals("Follow")){
			userMapper.createFollow(followTemp);
		} else {
			userMapper.deleteFollow(followTemp);
			
		}
		
	}

}
