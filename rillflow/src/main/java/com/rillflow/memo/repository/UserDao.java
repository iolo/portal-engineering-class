package com.rillflow.memo.repository;

import org.springframework.stereotype.Repository;

import com.rillflow.memo.model.User;

@Repository
public interface UserDao {
	int insertUser(User user);
	int updateUser(User user);
	int deleteUser(String id);
	User selectUser(String id);
}