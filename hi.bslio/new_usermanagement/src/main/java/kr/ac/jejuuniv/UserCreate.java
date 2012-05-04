package kr.ac.jejuuniv;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

// <<6>> UserCreate Controller 생성 및 구현

@Controller
@RequestMapping("/save")
public class UserCreate {
	@Autowired
	private UserService userService;

	@RequestMapping
	public String insert(String id, String name, String password) {
		if(userService.read(id) == null)
			userService.create(new User(id, name, password));
		else{
			// <<11>> UserModify 구현을 위해 수정
			userService.modify(new User(id, name, password));
		}
		return "redirect:/list";
	}
	
}
