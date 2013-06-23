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
		
		//�α��� Ȯ��
		
		//�α��� ���� Ȥ�� �α��� ���� ��Ű�� ���� ���
		registrationGuest();
		
		List<Comment> list = commentService.findAll();
		request.setAttribute("list", list);
		request.setAttribute("UserState", "Guset");
		RedirectView rd = new RedirectView("./list");
	}
	
	public void registrationGuest() {
		//Gest ��Ű ���� (�α��ν� ������ ���� ��Ű �⺻�� GuestUser ��Ű)
	}

	@RequestMapping("/listUser")
	public void callListByUser() {

	}

}
