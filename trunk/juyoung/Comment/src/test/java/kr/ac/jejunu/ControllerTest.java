package kr.ac.jejunu;

import javax.servlet.http.HttpServletRequest;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/resources/spring/servlet-context.xml")
public class ControllerTest {
	
	@Autowired
	private CommentController controller;
	
	@Test
	public void listPage(){
		MockHttpServletRequest request = new MockHttpServletRequest();
		
	}

}
