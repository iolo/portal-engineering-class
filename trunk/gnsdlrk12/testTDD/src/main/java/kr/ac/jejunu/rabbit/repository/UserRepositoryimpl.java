package kr.ac.jejunu.rabbit.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import kr.ac.jejunu.rabbit.model.User;

@Repository
public class UserRepositoryimpl implements UserRepository {
	
	 static List<User> users;

	 
	 public UserRepositoryimpl(){
		 users = new ArrayList<User>();
			
			users.add(new User("1", "가나다", "1233"));
			users.add(new User("2", "정재훈", "1233"));
			users.add(new User("3", "홍길동", "1233"));
		 
	 }
	@Override
	public void insert(User user) {
		// TODO Auto-generated method stub

	}

	@Override
	public void update(User user) {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(String id) {
		// TODO Auto-generated method stub

	}

	@Override
	public User findById(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<User> findAll() {
		return users;
	}

}
