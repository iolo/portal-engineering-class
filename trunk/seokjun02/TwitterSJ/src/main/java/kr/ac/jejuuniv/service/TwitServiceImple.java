package kr.ac.jejuuniv.service;

import java.util.List;

import kr.ac.jejuuniv.mapper.UserPostMapper;
import kr.ac.jejuuniv.model.Post;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TwitServiceImple implements TwitService {

	@Autowired
	private UserPostMapper userPostMapper;

	@Override
	public List<Post> showPostById(String userid) {
		return userPostMapper.showPostById(userid);
	}

}
