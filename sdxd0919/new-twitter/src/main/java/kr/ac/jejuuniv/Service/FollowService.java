package kr.ac.jejuuniv.Service;

import java.util.List;

import kr.ac.jejuuniv.Model.Follow;
import kr.ac.jejuuniv.Model.User;

public interface FollowService {

	List<User> getFollowingUserNum(int userNum);

	List<User> getFollowerUserNum(int userNum);

	List<Follow> checkFollowerUsers(int userNum);

	void unfollowUser(int userNum, int followingUserNum);

	void followUser(int userNum, int followingUserNum);

	List<Follow> checkAllUsers(int userNum);

}
