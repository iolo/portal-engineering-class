package jnu.ce.bs.userservice;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class UserServiceTest {
	UserServiceImpl userService = new UserServiceImpl();
	List<User> users = new ArrayList<User>();

	@Test
	public void userListGet() {
		users = userService.findAll();

		assertNotNull(users);
		assertThat(users.get(0).getId(), is("1"));
	}

	@Test
	public void findUserById() {
		String userId;
		userId = "2";
		users = userService.findById(userId);
		assertThat(users.get(0).getId(), is(userId));

	}

	@Test
	public void userAdd() {
		String id, name, password;
		id = "2";
		name = "사람";
		password = "멍청이";
		users = userService.createUser(id, name, password);
		assertThat(users.get(users.size() - 1).getId(), is(id));
		assertThat(users.get(users.size() - 1).getName(), is(name));
		assertThat(users.get(users.size() - 1).getPassword(), is(password));
	}

	@Test
	public void userDelete() {
		String userId;
		userId = "2";
		users = userService.deleteByID(userId);
		
		for (User user : users) {
			if (user.getId().equals(userId))
				fail();
		}
		
	}
	
	@Test
	public void userModify() {
		String userId, modifyName, modifyPassword;
		userId = "1";
		modifyName = "수정이름";
		modifyPassword = "수정비번";
		
		users = userService.modifyUserById(userId, modifyName, modifyPassword);
		
		int userNo = 0;
		for(int i=0; i < users.size(); i++){
			if(users.get(i).getId().equals(userId))
				userNo = i;
		}
		assertThat(users.get(userNo).getId(), is(userId));
		assertThat(users.get(userNo).getName(), is(modifyName));
		assertThat(users.get(userNo).getPassword(), is(modifyPassword));
	}
}
