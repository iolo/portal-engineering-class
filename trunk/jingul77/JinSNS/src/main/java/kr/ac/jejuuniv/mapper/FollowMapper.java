package kr.ac.jejuuniv.mapper;


import java.util.List;

import kr.ac.jejuuniv.model.TotalUserModel;

import org.springframework.stereotype.Repository;

@Repository
public interface FollowMapper {

	List<TotalUserModel> follower(String id);

	List<TotalUserModel> followAll(String id);

}
