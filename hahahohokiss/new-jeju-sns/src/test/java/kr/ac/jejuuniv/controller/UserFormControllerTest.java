package kr.ac.jejuuniv.controller;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import kr.ac.jejuuniv.model.User;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.mock.web.MockHttpSession;
import org.springframework.web.servlet.ModelAndView;

@RunWith(MockitoJUnitRunner.class)
public class UserFormControllerTest {
	
	UserFormController userFormController;
	
	@Mock
	MockHttpSession session;
	
	@Test
	public void testUserFormAction() {
		session = new MockHttpSession();
		userFormController = new UserFormController();
		User user = new User();
		String userId = "userId";
		user.setLoginId(userId);
		session.setAttribute("loginUser", user);
		
		
		ModelAndView returnModelAndView = userFormController.userFormAction(session);
		user = (User) returnModelAndView.getModel().get("loginUser");
		assertThat(returnModelAndView.getViewName(), is("/service/userform"));
		assertThat(user.getLoginId(), is("userId"));
	}
}
