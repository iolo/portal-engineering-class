package kr.bong.replyboard;

import java.io.File;
import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import kr.bong.replyboard.model.User;
import kr.bong.replyboard.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.context.ServletContextAware;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class UserController {

	public static final String PROFILE_IMAGE_PATH = 
			"C:/BongGyun/project/spring/workspace/ReplyBoard/src/main/webapp/resources/profile/";
	
	@Autowired
	UserService userService;

	@RequestMapping(value = "/login")
	public String login(Model model, HttpServletRequest request) {
		String fail = request.getParameter("fail");
		
		model.addAttribute("fail", fail);
		
		return "user/login";
	}

	@RequestMapping(value = "/loginProcess")
	public String loginProcess(User user, HttpSession session) {

		User loginUser = userService.loginCheck(user.getId(), user.getPassword());

		if (loginUser != null) {
			session.setAttribute("user", loginUser);

			return "redirect:/write";
		} else {
			return "redirect:/login?fail=1";
		}
	}

	@RequestMapping(value = "/logout")
	public String logout(HttpSession session) {
		session.setAttribute("user", null);
		return "redirect:/";
	}

	@RequestMapping(value = "/user/join")
	public String join(Model model, HttpServletRequest request) {
		String referURL = request.getHeader("referer");
		
		model.addAttribute("referURL", referURL);
		
		return "user/join";
	}
	
	@RequestMapping(value = "/user/joinProcess")
	public String joinProcess(User user, HttpServletRequest request) {
		String referURL = request.getParameter("referURL");

		MultipartFile imageFile = user.getProfFile();
		moveFile(imageFile);
		user.setProfPath(imageFile.getOriginalFilename());
		
		userService.join(user);
		return "redirect:"+referURL;
	}

	@RequestMapping(value = "/user/modify")
	public String modify(Model model, HttpServletRequest request, HttpSession session) {
		String referURL = request.getHeader("referer");
		User user = (User) session.getAttribute("user");
		
		model.addAttribute("referURL", referURL);
		model.addAttribute("user", user);
		
		return "user/join";
	}

	@RequestMapping(value = "/user/modifyProcess")
	public String modifyProcess(User user, HttpServletRequest request, HttpSession session) {
		String referURL = request.getParameter("referURL");
		
		MultipartFile imageFile = user.getProfFile();
		moveFile(imageFile);
		user.setProfPath(imageFile.getOriginalFilename());
		
		userService.modify(user);
		
		// 수정 데이터 세션에 반영
		session.setAttribute("user", user);
		
		return "redirect:"+referURL;
	}

	/**
	 * 파일 이동 수행
	 */
	private void moveFile(MultipartFile imageFile) {
		File file = new File(PROFILE_IMAGE_PATH + imageFile.getOriginalFilename());
		
		try {
			imageFile.transferTo(file);
		} catch (IllegalStateException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
