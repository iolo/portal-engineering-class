//package kr.ac.jejuuniv.twitter.controller.test;
//
//import static org.junit.Assert.assertThat;
//import static org.hamcrest.Matchers.is;
//import static org.springframework.test.util.ReflectionTestUtils.*;
//import static org.mockito.Mockito.when;
//import static org.mockito.Mockito.verify;
//
//import kr.ac.jejuuniv.twitter.controller.LoginController;
//import kr.ac.jejuuniv.twitter.model.UserModel;
//import kr.ac.jejuuniv.twitter.repository.UserRepository;
//import kr.ac.jejuuniv.twitter.service.TwitterService;
//import kr.ac.jejuuniv.twitter.service.UserService;
//import kr.ac.jejuuniv.twitter.service.impl.UserServiceImpl;
//
//import org.apache.taglibs.standard.tag.common.xml.WhenTag;
//import org.junit.Before;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.mockito.invocation.InvocationOnMock;
//import org.mockito.runners.MockitoJUnitRunner;
//import org.mockito.stubbing.Answer;
//import org.springframework.mock.web.MockHttpServletRequest;
//import org.springframework.test.AssertThrows;
//import org.springframework.test.util.ReflectionTestUtils;
//import org.springframework.web.servlet.ModelAndView;
//import org.springframework.web.servlet.handler.UserRoleAuthorizationInterceptor;
//
//
//@RunWith(MockitoJUnitRunner.class)
//public class LoginControllerTest {
//	
//	@Mock
//	private UserService userService;
//	
//	@Mock
//	private UserRepository userRepository;
//	
//	
//	@InjectMocks
//	private LoginController loginController = new LoginController();
//	
//	private ModelAndView model;
//	private MockHttpServletRequest request = null;
//	UserModel user = new UserModel();
//	
//	@Before
//	public void setUp(){
//		user.setId("juntheater");
//		user.setPassword("qwer");
//		ReflectionTestUtils.invokeMethod(userRepository, "addUser", user);
//		ReflectionTestUtils.setField(loginController, "userService", userService);
//		model = new ModelAndView();
//		request = new MockHttpServletRequest();
//	}
//	
//	@Test
//	public void LoginControllerTester(){
//		UserModel user2 = new UserModel();
//		user2.setId("juntheater");
//		user2.setPassword("qwer");
//		
//		when(userService.checkUser(user)).thenAnswer(new Answer<UserModel>() {
//
//			public UserModel answer(InvocationOnMock invocation)
//					throws Throwable {
//				UserModel user = new UserModel();
//				user.setId("juntheater");
//				user.setPassword("1234");
//				return user;
//			}
//			
//		});
//		
//		model = loginController.Login(user, request);
//		//verify는 호출 여부를 체크 해준다??
//		verify(userService).checkUser(user);
//		
////		assertThat(((UserModel)model.getModel().get("user")).getName(),is("Young Jun Moon"));
//		assertThat(model.getViewName(),is("main"));
//	}
//}
