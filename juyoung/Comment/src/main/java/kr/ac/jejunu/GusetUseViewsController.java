package kr.ac.jejunu;

import java.util.Collections;
import java.util.List;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.ac.jejunu.model.Comment;
import kr.ac.jejunu.model.UserInfo;
import kr.ac.jejunu.repositry.CommentService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class GusetUseViewsController {
	@Autowired
	private CommentService service;
	
	@RequestMapping("/")
	public String pageNotFound(HttpServletResponse response){
		response.addCookie(new Cookie("user", "guset"));
		return "error";
	}

	@RequestMapping("/list")
	public String requestList(@CookieValue("user")String user, HttpServletRequest request,
			HttpServletResponse response) {
		// get parameter 확인
		String pageParameter = request.getParameter("page");
		if(user == null || user == "guset"){
			response.addCookie(new Cookie("user", "guset"));
		}else{
			request.setAttribute("userName", user);
		}

		int nowPage;
		try {
			nowPage = Integer.parseInt(pageParameter);
		} catch (NumberFormatException e) {
			nowPage = 1;
		}
		// 페이지 수 확인
		int pageCount = service.pageCount();

		// 페이지에 따라 코멘트 호출
		List<Comment> list = service.showPageOne(nowPage);
		// 데이터 저장
		Collections.reverse(list);
		request.setAttribute("list", list);
		request.setAttribute("pageCount", pageCount);
		// 로그인 구별
		if (user == null || user == "guset") {
			response.addCookie(new Cookie("user", "guset"));
			request.setAttribute("user", "guset");
		} else {
			request.setAttribute("user", user);
		}
		return "list";
	}

	@RequestMapping("/join.write")
	public String requsetJoinFrom() {
		return "join";
	}

	@RequestMapping("/join.save")
	public String requestJoinSave(@RequestParam("file") MultipartFile file,
			@ModelAttribute("joinUserInfo") UserInfo user) {
		user = service.isProfile_urlUploadAndUserInfoAdd(file, user);
		service.joinUser(user);
		return "redirect:/list";
	}

	@RequestMapping(value = "/image", produces = {"image/jpeg"})
	public @ResponseBody HttpEntity<byte[]> getImage(HttpServletRequest request,
			HttpServletResponse response) {
		return service.getImage(request);
	}
}
