package kr.ac.jejuuniv.Repository;

import kr.ac.jejuuniv.Model.User;

public interface PersonalSnsRepository {

	User findByUserNum(int userNum);

}
