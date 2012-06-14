package kr.ac.jejuuniv.service.user;

import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.multipart.MultipartFile;

import kr.ac.jejuuniv.model.User;
import kr.ac.jejuuniv.repository.user.UserRepository;

@Service
public class UserServiceImpl implements UserService {

	private static final String FILE_PATH = "E:\\LazyMars\\workspace-sts-2.9.2.RELEASE\\minsbook\\src\\main\\webapp\\WEB-INF\\images";
	
	User user;
	
	@Autowired
	UserRepository userRepository;

	@Override
	public List<User> getList() {
		return userRepository.findAll();
	}

	@Override
	public void saveUser(String id, String password, String name,
			String nickName, MultipartFile profileImgPath) {
		String imageURI;

		imageURI = profileImgPath.getOriginalFilename();

		String filePath = FILE_PATH;
		File file = new File(filePath + imageURI);
		try {
			profileImgPath.transferTo(file);
		} catch (Exception e) {
			e.printStackTrace();
		}

		User userModel = new User(id, password, name, nickName, profileImgPath.getOriginalFilename());

		userRepository.saveUser(userModel);		
	}
	
	@Override
	public boolean loginCheck(String id, String password, Model model) {

		Map<String, String> LoginMap = new HashMap<String, String>();
		LoginMap.put("id", id);
		LoginMap.put("password", password);
		user = userRepository.findById(id);
		
		if (user != null) {
			model.addAttribute("user", user);			
			return true;
			}
			else 
			return false;
	}

}
