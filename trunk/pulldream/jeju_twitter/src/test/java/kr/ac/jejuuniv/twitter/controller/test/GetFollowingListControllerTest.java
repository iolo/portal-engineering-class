package kr.ac.jejuuniv.twitter.controller.test;

import static org.junit.Assert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.springframework.test.util.ReflectionTestUtils.*;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.verify;

import kr.ac.jejuuniv.twitter.controller.FollowingController;
import kr.ac.jejuuniv.twitter.controller.LoginController;
import kr.ac.jejuuniv.twitter.model.FollowModel;
import kr.ac.jejuuniv.twitter.model.UserModel;
import kr.ac.jejuuniv.twitter.repository.UserRepository;
import kr.ac.jejuuniv.twitter.service.TwitterService;
import kr.ac.jejuuniv.twitter.service.UserService;
import kr.ac.jejuuniv.twitter.service.impl.UserServiceImpl;

import org.apache.taglibs.standard.tag.common.xml.WhenTag;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.runners.MockitoJUnitRunner;
import org.mockito.stubbing.Answer;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.test.AssertThrows;
import org.springframework.test.util.ReflectionTestUtils;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.UserRoleAuthorizationInterceptor;


@RunWith(MockitoJUnitRunner.class)
public class GetFollowingListControllerTest {
	
	@Mock
	private TwitterService twitterService;
	
	
	@InjectMocks
	private FollowingController followingController = new FollowingController();
	
	private ModelAndView model;
	private MockHttpServletRequest request = null;
	
	@Before
	public void setUp(){
		
		request = new MockHttpServletRequest();
		model = new ModelAndView();
		request = new MockHttpServletRequest();
		ReflectionTestUtils.setField(followingController, "twitterService", twitterService);
	}
	
	@Test
	public void LoginControllerTester(){
		UserModel user2 = new UserModel();
		FollowModel followModel = new FollowModel();
		
		
		when(twitterService.getFollowingList("juntheater")).thenAnswer(new Answer<FollowModel>() {

			public FollowModel answer(InvocationOnMock invocation)
					throws Throwable {
				FollowModel followModel = new FollowModel();
				followModel.setId("juntheaetr");
				followModel.setFollowing("asdf");
				return followModel;
			}
			
		});
		
//		model = followingController.getFollowingList(request);
		
//		assertThat(((UserModel)model.getModel().get("user")).getName(),is("Young Jun Moon"));
		assertThat(model.getViewName(),is("followinglist"));
		System.out.println(model.getModel().get("followingList"));
	}
}
