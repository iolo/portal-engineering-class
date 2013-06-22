package kr.mg.comment;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import kr.mg.comment.model.Comment;
import kr.mg.comment.model.User;
import kr.mg.comment.service.CommentService;
import kr.mg.comment.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {

	@Autowired
	UserService userservice;

	@Autowired
	CommentService commentservice;

	@RequestMapping(value = "/")
	public String home(Model model) {
		model.addAttribute("comments",commentservice.getList());
		return "home";
	}

	@RequestMapping(value = "writeComment")
	public String writeComment() {
		return "writeComment";
	}

	@RequestMapping(value = "/commentProcess")
	public String commentprocess(Comment comment, HttpSession session) {
		User user;
		String id;
		user = (User) session.getAttribute("userLoginInfo");
		id = user.getId();
		comment.setId(id);
		commentservice.insertCommentData(comment);

		return "redirect:/";
	}

	@RequestMapping(value = "/login")
	public String login(Model model, HttpServletRequest request) {
		String fail = request.getParameter("fail");

		model.addAttribute("fail", fail);

		return "login";
	}

	// 로그아웃
	@RequestMapping("logout")
	public String logout(HttpSession session) {
		session.setAttribute("userLoginInfo", null);
		return "redirect:login";
	}

	// 로그인 처리
	@RequestMapping(value = "loginProcess")
	public String loginProcess(User user, HttpSession session,
			HttpServletRequest request) {

		User loginUser = userservice.login(user);

		if (loginUser != null) {
			session.setAttribute("userLoginInfo", user);
			return "redirect:writeComment";
		} else {
			return "redirect:login?fail=1";
		}
	}

	@RequestMapping(value = "/join")
	public String join() {
		return "join";
	}

	@RequestMapping(value = "/joinProcess")
	public String joinprocess(User user) {

		userservice.join(user);

		return "redirect:/";
	}
}
