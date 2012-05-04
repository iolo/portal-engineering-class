package kr.juntheater.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestMapping;

import kr.juntheater.model.User;

@Repository
public class UserRepositoryImp implements UserRepository {

	public static List<User> user;
	
	public UserRepositoryImp(){
		user = new ArrayList<User>();
		user.add(new User("juntheater","dreamtheater","dkssudgktpdy"));
	}
	
	public List<User> findAll() {
		return user;
	}

	public void insert(String id, String name, String password) {
		user.add(new User(id,name,password));
	}
	
	public User read(String id){
		for (int i = 0; i < user.size(); i++) {
			if(user.get(i).getId().equals(id))	return user.get(i); 
		}
		return null;
	}
	
	//포이치 쓰는법 좀 갈쳐주라 이 나쁜 정흠씨?? ㅋif(User user :  users){메소드}
	public void delete(String id) {
		user.remove(read(id));
	}
	
	public void modify(User user){
		User modifyUser = read(user.getId());
		modifyUser.setName(user.getName());
		modifyUser.setPassword(user.getPassword());
	}
}
