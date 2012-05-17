package kr.ac.jejuuniv.persistence;

import java.util.List;

import kr.ac.jejuuniv.model.User;


public interface UserMapper {

	List<User> findAll();

	List<User> findAllOrderByIdDesc();

}
