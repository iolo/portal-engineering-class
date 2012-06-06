package kr.ac.jejuuniv.mapper;

import org.apache.ibatis.annotations.Param;


public interface UserMapper {
	int checkUser(@Param("id") String id, @Param("password") String password);
}
