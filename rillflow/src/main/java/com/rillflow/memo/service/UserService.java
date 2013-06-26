package com.rillflow.memo.service;

import com.rillflow.memo.model.User;

public interface UserService {
	int join(User user);
	int modify(User user);
	int remove(String id);
	User getUser(String id);
	User login(String id, String password);
}
