package kr.ac.jejunu;

import java.util.Collections;
import java.util.List;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.ac.jejunu.model.Comment;
import kr.ac.jejunu.repositry.CommentService;
import kr.ac.jejunu.repositry.SqlMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.view.RedirectView;

@Controller
@RequestMapping
public class GusetUseController {
	@Autowired
	private CommentService service;

	@RequestMapping("/")
	public String callListByGest(HttpServletRequest request,
			HttpServletResponse response) {
		// get parameter 확인
		String pageParameter = request.getParameter("page");
		Cookie[] cookies = request.getCookies();
		String user = "";
		try {
			for (int check = 0; check < cookies.length; check++) {
				if (cookies[check].getName() == "user") {
					user = cookies[check].getValue();
					break;
				}
				user = null;
			}
		} catch (NullPointerException e) {
			request.setAttribute("user", "guset");
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

}
