package jnu.ce.bs.k.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jnu.ce.bs.k.model.Follow;
import jnu.ce.bs.k.model.User;
import jnu.ce.bs.k.persistence.UserMapper;

@Service
public class FollowServiceImpl implements FollowService {
	
	@Autowired
	private UserMapper userMapper;
	
	@Autowired
	private UserService userService;
	
	@Override
	public List<User> findFollowUserById(User user) {
		List<Follow> follows = new ArrayList();
		follows = userMapper.findFollowUserByID(user.getId());

		List<User> users = new ArrayList();
		users = userService.findAllUser(user);

		for (int count = 0; count < users.size(); count++) {
			for (int followcount = 0; followcount < follows.size(); followcount++) {
				if (users.get(count).getId()
						.equals(follows.get(followcount).getFollowing_id())) {
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

	@Override
	public List<User> findFollowingByUserId(String id) {
		List<User> users = new ArrayList();
		users = userMapper.findFollwingByUserId(id);

		List<Follow> follows = new ArrayList();
		follows = userMapper.findFollowUserByID(id);

		for (int i = 0; i < users.size(); i++) {
			users.get(i).setUserNum("true");
		}

		return users;
	}

	@Override
	public List<User> findFollowerByUserId(String id) {
		List<User> users = new ArrayList();
		users = userMapper.findFollwerByUserId(id);

		List<Follow> follows = new ArrayList();
		follows = userMapper.findFollowUserByID(id);

		for (int i = 0; i < users.size(); i++) {
			for (int count = 0; count < follows.size(); count++) {
				if (users.get(i).getId()
						.equals(follows.get(count).getFollowing_id())) {
					users.get(i).setUserNum("true");
				}
			}
		}

		return users;
	}

}
