package kr.ac.jejunu.kdi.repository;

import java.util.ArrayList;
import java.util.List;

import kr.ac.jejunu.kdi.model.User;

import org.springframework.stereotype.Repository;

@Repository
public class UserRepositoryImpl implements	UserRepository {
	
	public static List<User> users;
	
	public UserRepositoryImpl(){
		users  = new ArrayList<User>();
		users.add(new User("kdi8787", "강동인", "1234"));
		users.add(new User("kdi1234", "이재휸", "1234"));
	}
	
	public List<User> findAll(){
		return users;
	}
	
	public void addUser(User user){
		users.add(user);
	}

	@Override
	public void createUser(String id, String name, String password) {
		users.add(new User(id, name,password));
		
	}
	
	@Override
	public void deleteUser(String id){
		for(int i=0; i < users.size(); i++){
			if(users.get(i).getId().equals(id)){
				users.remove(i);
			}
		}
	}
}
