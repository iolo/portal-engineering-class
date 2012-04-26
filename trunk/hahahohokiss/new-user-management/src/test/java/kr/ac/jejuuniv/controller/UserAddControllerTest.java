package kr.ac.jejuuniv.controller;

import static org.hamcrest.CoreMatchers.is;
import kr.ac.jejuuniv.model.User;

import static org.junit.Assert.*;
import org.junit.Test;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.web.servlet.ModelAndView;

public class UserAddControllerTest {
	UserAddController userAddController;
	MockHttpServletRequest request;
	MockHttpServletResponse response;

	@Test
	public void testAdd() {
		// User 값 입력
		// redirect:list
		
		userAddController = new UserAddController();
		
		User user = new User();
		user.setId("0");
		user.setName("한진수");
		user.setPassword("비밀번호");
		ModelAndView modelAndView = userAddController.add(user);
		
		assertThat(((User)modelAndView.getModel().get("user")).getId(), is("0"));
		assertThat(((User)modelAndView.getModel().get("user")).getName(), is("한진수"));
		assertThat(((User)modelAndView.getModel().get("user")).getPassword(), is("비밀번호"));
		assertThat(modelAndView.getViewName(), is("redirect/:list"));
		
	}
}
