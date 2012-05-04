package kr.ac.jejuuniv.test;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

@Repository
public class UserRepositoryImpl implements UserRepository {
	private List<User> users;
	
	public UserRepositoryImpl(){
		users = new ArrayList<User>();
		users.add(new User("jingul77", "양진걸", "1234"));
		users.add(new User("iclab", "연구실", "1234"));
		users.add(new User("facebook", "페북", "1234"));
		users.add(new User("jeju", "제주도", "1234"));
		users.add(new User("avante", "아반떼", "1234"));
		
	
		
	}

	@Override
	public void insert(User user) {
		// TODO Auto-generated method stub

	}

	@Override
	public void update(String id, String name, String password) {
		for(int index=0; index < users.size(); index++) {
			if(users.get(index).getId().equals(id)) {
				users.get(index).setId(id);
				users.get(index).setName(name);
				users.get(index).setPassword(password);
			}
		}
	}

	@Override
	public void delete(String id) {
		for(int i =0;i<users.size();i++) {
			if(users.get(i).getId().equals(id)){
				users.remove(i);
			}
				
		}

	}

	@Override
	public User findById(String id) {
		for(int index=0; index < users.size(); index++) {
			if(users.get(index).getId().equals(id)) {
				
				return users.get(index);
			}
		}
		return null;
	}

	@Override
	public java.util.List<User> findAll() {
		return users;
	}

	@Override
	public java.util.List<User> List() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void addUser(String id, String name, String password) {
		users.add(new User(id, name, password));
		
	}

}
