package jnu.ce.bs.k.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import jnu.ce.bs.k.model.Follow;
import jnu.ce.bs.k.model.Note;
import jnu.ce.bs.k.model.User;
import jnu.ce.bs.k.persistence.UserMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserMapper userMapper;

	@Override
	public void createUser(String id, String password, String name,
			String description, String profile) {

		User user = new User(id, password, name, description, profile);
		userMapper.addUser(user);
	}

	@Override
	public User login(Map<String, String> map) {

		return userMapper.login(map);
	}

	@Override
	public List<Note> findAllNoteByID(String id) {
		
		return userMapper.findAllNoteById(id);
	}

	@Override
	public List<User> findAllUser(User user) {
		List<User> users = new ArrayList();
		users = userMapper.findAllUser();
		
		for(int count=0; count<users.size(); count++){
			if(users.get(count).getName().equals(user.getName())){
				users.remove(count);
			}
		}
		
		return users;
	}

	@Override
	public void modifyUser(String name, String password, String description,
			String profile, User user) {
		user.setName(name);
		user.setPassword(password);
		user.setDescription(description);
		user.setProfile(profile);
		
		userMapper.modifyUser(user);
	}

	@Override
	public List<User> findFollowUserById(User user) {
		List<Follow> follows = new ArrayList();
		follows = userMapper.findFollowUserByID(user.getId());
		
		List<User> users = new ArrayList(); 
		users = findAllUser(user);
		
		for(int count=0; count<users.size(); count++){
			for(int followcount=0; followcount<follows.size(); followcount++){
				if(users.get(count).getId().equals(follows.get(followcount).getFollowing_id())){
					users.get(count).setUserNum("true");
				}
			}
		}
		
		return users;
	}

	@Override
	public void follow(Map<String, String> map) {
		userMapper.follow(map);
		
	}

	@Override
	public void unfollow(Map<String, String> map) {
		userMapper.unfollow(map);
	}

}
