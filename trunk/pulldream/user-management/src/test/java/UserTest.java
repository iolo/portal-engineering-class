import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


@RunWith(MockitoJUnitRunner.class)
public class UserTest {
	private UserService userServ = new UserServiceImpl();
	
	@Mock
	private UserRepository repository;
	
	@Test
	@Rollback(true)
	public void getTest(){
		User user = userServ.get("DreamTheater");
		
		assertNotNull(user);
		assertEquals("Tour", user.getName());
	}
	
	@Test
	@Rollback(true)
	public void delTest() {
		User user =  userServ.get("DreamTheater");
		repository.delete("DreamTheater");
		assertNull(user);
	}
}
