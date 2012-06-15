package kr.ac.jejuuniv.Repository;

import java.util.List;

public interface FollowRepository {

	List<Integer> getFollowingUserNumList(int userNum);

	List<Integer> getFollowerUserNumList(int userNum);

	void unfollow(int userNum, int followingUserNum);

	void follow(int userNum, int followingUserNum);

}
