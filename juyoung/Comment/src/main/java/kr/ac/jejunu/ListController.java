package kr.ac.jejunu;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import kr.ac.jejunu.model.Comment;
import kr.ac.jejunu.repositry.CommentService;
import kr.ac.jejunu.repositry.SqlMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.view.RedirectView;

@Controller
@RequestMapping("/list")
public class ListController {
	@Autowired
	private CommentService commentService;

	@RequestMapping
	public void callListByGest(HttpServletRequest request) {
		
		//로그인 확인
		
		//로그인 정보 혹은 로그인 정보 쿠키가 없는 경우
		registrationGuest();
		
		List<Comment> list = commentService.findAll();
		request.setAttribute("list", list);
		request.setAttribute("UserState", "Guset");
		RedirectView rd = new RedirectView("./list");
	}
	
	public void registrationGuest() {
		//Gest 쿠키 생성 (로그인시 정보가 들어가는 쿠키 기본은 GuestUser 쿠키)
	}

	@RequestMapping("/listUser")
	public void callListByUser() {

	}

}
