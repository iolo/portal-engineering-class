package kr.ac.jejuuniv.Service;

public class PersonalSnsServiceTest {
	
	//userNum 받아서, name과 user의 tweet 정보 가져오기.
	@Test
	public void action(){
		UserRepository userRepository;
		UserService userSerivce = new UserServiceImpl(userRepository);
		
		User user = userSerive.getUser(1);
		
		assertThat(user.getUserNum(), is(1));
		assertThat(user.getName(), is("현소영"));
	}
	
}
