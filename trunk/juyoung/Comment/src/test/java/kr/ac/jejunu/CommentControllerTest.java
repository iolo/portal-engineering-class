package kr.ac.jejunu;


import static org.junit.Assert.*;

import java.util.Collection;
import java.util.Map;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.ui.Model;
import org.springframework.web.servlet.ModelAndView;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring/servlet-context.xml")
public class CommentControllerTest {
	
	@Autowired
	private CommentController commentController;
	
	@Test
	public void listpage(){
				
	}
	
	
}
