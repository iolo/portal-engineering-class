package kr.ac.jejunu;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import kr.ac.jejunu.model.Comment;
import kr.ac.jejunu.repositry.SqlMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.view.RedirectView;


@Controller
@RequestMapping("/list")
public class listController {
	@Autowired
	private SqlMapper mapper;
	
	@RequestMapping
	public void callListByGest(HttpServletRequest request) {
		List<Comment> list = mapper.getAllList();
		request.setAttribute("list", list);
		RedirectView rd = new RedirectView("./list");
	}
	
}
