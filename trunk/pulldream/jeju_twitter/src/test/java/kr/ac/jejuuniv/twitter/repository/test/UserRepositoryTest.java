package kr.ac.jejuuniv.twitter.repository.test;

import java.util.ArrayList;
import java.util.List;

import kr.ac.jejuuniv.twitter.model.TwittModel;
import kr.ac.jejuuniv.twitter.model.UserModel;
import kr.ac.jejuuniv.twitter.repository.UserRepository;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:/mybatis/repository.xml")
public class UserRepositoryTest {

	@Autowired
	private UserRepository userRepository;
	
	private UserModel user = new UserModel();
	
	@Before
	public void setUser(){
		user.setId("juntheater3");
		user.setName("Young");
		user.setPassword("asdf");
		user.setProfile("안녕하세요");
	}
	
	@Test
	public void addUserTest() {
		//사용자 넣기 테스트
		userRepository.addUser(user);
//		userRepository.deleteUser(user.getId());
	}
	
	@Test
	public void getAllUserTest(){
		//모든 사용자를 보여주기 위한 테스트
		List<UserModel> user = new ArrayList<UserModel>();
		
		user = userRepository.getAllUser();
		
		System.out.println("----------------------------------------");
		for (int i = 0; i < user.size(); i++) {
			System.out.println("getAllUserTest");
			System.out.println("user Id : " + user.get(i).getId());
			System.out.println("user Name : "+user.get(i).getName());
			System.out.println("user Password : "+user.get(i).getPassword());
			System.out.println();
		}
		System.out.println("----------------------------------------");
	}
}
