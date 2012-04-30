package kr.ac.jejuuniv.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import kr.ac.jejuuniv.model.User;

@Repository
public class UserRepositoryImpl implements UserRepository {
	
	private static List<User> users ;
	
	public UserRepositoryImpl(){
		users = new ArrayList<User>();
		User user1 = new User("0", "한진수", "비밀번호");
		User user2 = new User("1", "이진수", "비밀번호");
		User user3 = new User("2", "삼진수", "비밀번호");
		User user4 = new User("3", "사진수", "비밀번호");
		User user5 = new User("4", "오진수", "비밀번호");
		User user6 = new User("5", "육진수", "비밀번호");
		users.add(user1);
		users.add(user2);
		users.add(user3);
		users.add(user4);
		users.add(user5);
		users.add(user6);
	}

	public List<User> findAll() {
		return users;
	}

	public User findById(String id) {
		for(int i=0; i<users.size(); i++) {
			if(users.get(i).getId().equals(id)){
				return users.get(i);
			}
		}
		return null;
	}

	public User insert(User user) {
		users.add(user);
		return user;
	}

	public User update(User user) {
		for(int i=0; i<users.size(); i++) {
			if(users.get(i).getId().equals(user.getId())) {
				users.get(i).setName(user.getName());
				users.get(i).setPassword(user.getPassword());
			}
		}
		return user;
	}

	public void delete(String id) {
		for(int i=0; i<users.size(); i++) {
			if(users.get(i).getId().equals(id)) {
				users.remove(i);
			}
		}
	}

}
