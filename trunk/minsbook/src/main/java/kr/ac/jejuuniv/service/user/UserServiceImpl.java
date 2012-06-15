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
import kr.ac.jejuuniv.repository.exception.UserNotFoundException;
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
	public void saveUser(User user, MultipartFile profileImg) {
		String imageURI, id, password, name, nickName;

		imageURI = profileImg.getOriginalFilename();

		String filePath = FILE_PATH;
		File file = new File(filePath + imageURI);
		try {
			profileImg.transferTo(file);
		} catch (Exception e) {
			e.printStackTrace();
		}
		id = user.getId();
		password = user.getPassword();
		name = user.getName();
		nickName = user.getNickName();

		User userModel = new User(id, password, name, nickName,
				profileImg.getOriginalFilename());

		userRepository.saveUser(userModel);
	}

	@Override
	public boolean loginCheck(String id, String password, Model model) {

		Map<String, String> LoginMap = new HashMap<String, String>();
		LoginMap.put("id", id);
		LoginMap.put("password", password);
		
		try {
			user = userRepository.findById(id);
			model.addAttribute("user", user);
			return true;
		} catch (UserNotFoundException e) {
			return false;
		}

	}

}
