package kr.ac.jejuuniv.persistence;

import java.util.List;

import kr.ac.jejuuniv.model.User;

import org.apache.ibatis.annotations.Select;


public interface UserMapper {

	@Select("SELECT * FROM userinfo")
	List<User> findAll();

	@Select("SELECT * FROM userinfo ORDER BY id DESC")
	List<User> findAllOrderByIdDesc();

}
