package kr.ac.jejuuniv.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import kr.ac.jejuuniv.model.User;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("service/follow*")
public class FollowController extends BaseFormController {

	@RequestMapping
	public String followAction(String followingId, HttpSession session, HttpServletRequest request) {
		int subStringStart = request.getHeader("Referer").indexOf("/service");
		String redirectViewName = request.getHeader("Referer").substring(subStringStart);
		User user = (User) session.getAttribute("loginUser");
		userService.addFollow(user.getLoginId(), followingId);
		return "redirect:"+redirectViewName;
	}
}
