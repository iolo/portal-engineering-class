package kr.ac.jejuuniv.service;

import java.util.List;

import kr.ac.jejuuniv.mapper.UserMapper;
import kr.ac.jejuuniv.mapper.UserPostMapper;
import kr.ac.jejuuniv.model.Post;
import kr.ac.jejuuniv.model.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TwitServiceImple implements TwitService {

	@Autowired
	private UserPostMapper userPostMapper;
	@Autowired
	private UserMapper userMapper;

	@Override
	public List<Post> showPostById(String userid) {
		return userPostMapper.showPostByUserId(userid);
	}
	@Override
	public void deleteUserPost(String userId, long sequenceNumber) {
		userPostMapper.deleteUserPost(userId, sequenceNumber);
	}
	@Override
	public User getUser(String userId) {
		return userMapper.selectUser(userId);
	}
	@Override
	public void savePost(Post post) {
		userPostMapper.insertPost(post);
	}

}
