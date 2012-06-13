package kr.ac.jejunu.rabbit.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.ac.jejunu.rabbit.mapper.UserMapper;
import kr.ac.jejunu.rabbit.model.Post;
import kr.ac.jejunu.rabbit.model.User;

@Service
public class UserServiceImp implements UserService{
	User user;
	
	@Autowired
	UserMapper usermapper;
	
	@Override
	public void UserInsert(User user) {
		if (UserGet(user.getUserid()) == null)
			usermapper.UserInsert(user);
		else
			usermapper.UserUpdate(user);
	}

	@Override
	public void UserDelete(String userid) {
		usermapper.UserDelete(userid);
	}

	@Override
	public User UserGet(String userid) {
		return usermapper.findById(userid);
	}

	@Override
	public List<User> UserList() {
		List<User> users = usermapper.findUserAll();
		return users;
	}

	@Override
	public List<Post> GetUserPost(String userid) {
		List<Post> posts = usermapper.findPostAll(userid);
		return posts;
	}

	@Override
	public void PostInsert(String postid, String content) {
		usermapper.PostInsert(postid, content);
		
	}

	@Override
	public void following(String userid, String followerid) {
		usermapper.followInsert(userid, followerid);
		
	}

	@Override
	public boolean Login(String userid, String password) {
		if(usermapper.Check(userid, password) != null){
			user = usermapper.Check(userid, password);
			return true;
			
		}
		else{
			return false;
		}
	}

	@Override
	public void postDelete(String postid, int post_num) {
		usermapper.postDelete(postid, post_num);
	}

	@Override
	public void UserModify(User user) {
		usermapper.UserUpdate(user);
		
	}

}
