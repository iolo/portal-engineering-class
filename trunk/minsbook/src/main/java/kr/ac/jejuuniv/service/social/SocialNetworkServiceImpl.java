package kr.ac.jejuuniv.service.social;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.ac.jejuuniv.model.User;

@Service
public class SocialNetworkServiceImpl implements SocialNetworkService {

	@Override
	public List<User> getFollows(String userId) {
		return null;
	}

	@Override
	public List<User> getFollowers(String userId) {
		return null;
	}

	@Override
	public void follow(String followId) {

	}

	@Override
	public void unFollow(String unFollowId) {

	}

}
