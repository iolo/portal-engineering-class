package kr.ac.jejuuniv.Repository;

import java.util.List;

public interface FollowRepository {

	List<Integer> getFollowingUserNumList();

	List<Integer> getFollowerUsers();

}
