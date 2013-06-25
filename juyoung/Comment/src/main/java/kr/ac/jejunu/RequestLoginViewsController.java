package kr.ac.jejunu;

import java.lang.ProcessBuilder.Redirect;
import java.net.URLEncoder;
import java.util.Date;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.ac.jejunu.model.Comment;
import kr.ac.jejunu.model.UserInfo;
import kr.ac.jejunu.repositry.CommentService;

import org.omg.IOP.Encoding;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class RequestLoginViewsController {

	@Autowired
	private CommentService service;

	@RequestMapping("/login")
	public String loginPage(HttpServletRequest request) {
		System.out.println(request.getAttribute("preRequest"));
		return "login";
	}

	@RequestMapping("/login.check")
	public String login(@CookieValue(value = "user") String cookie,
			HttpServletRequest request, HttpServletResponse response) {
		String id = request.getParameter("userId");
		String password = request.getParameter("userPassword");
		if (service.checkLogin(id, password) == true) {
			return "login";
		}
		String userId = service.findUserInfoById(id).getId();
		System.out.println(userId);

		Cookie cookie2 = new Cookie("user", userId);
		response.addCookie(cookie2);
		
		return "redirect:list";
	}

	@RequestMapping("login.out")
	public String logout(HttpServletResponse response) {
		Cookie cookie = new Cookie("user", "guset");
		response.addCookie(cookie);
		return "redirect:/list";
	}

	@RequestMapping("/write")
	public String writeComment(@CookieValue(value = "user") String cookie,
			HttpServletRequest request) {
		if (cookie.equals("guset")) {
			request.setAttribute("preRequest", "write");
			return "login";
		}
		UserInfo userInfo = service.findUserInfoById(cookie);
		request.setAttribute("profile_url", userInfo.getProflie_url());
		request.setAttribute("name", userInfo.getName());
		return "/write";
	}

	@RequestMapping("/write.save")
	public String writeComment(@ModelAttribute("comment") Comment comment) {
		comment.setRegTime(new Date());
		service.writeComment(comment);
		return "redirect:list";
	}

	@RequestMapping("like")
	public String addlike(@CookieValue(value = "user") String cookie,
			HttpServletRequest request) {
			String like = request.getParameter("like");
			int comment =Integer.parseInt(request.getParameter("it"));
		if (cookie.equals("guset")) {
			System.out.println("Ȯ��");
			request.setAttribute("preRequest", "write");
			return "login";
		}
		service.addUserLikeComment(cookie, comment, like);
		return "redirect:list";
	}
}
