package kr.ac.jejuuniv.Service;

import java.util.List;

import kr.ac.jejuuniv.Model.Follow;
import kr.ac.jejuuniv.Model.User;

public interface FollowService {

	List<User> getFollowingUserNum();

	List<User> getFollowerUserNum();

	List<Follow> checkFollowerUsers();

	List<Follow> checkAllUsers();
}
