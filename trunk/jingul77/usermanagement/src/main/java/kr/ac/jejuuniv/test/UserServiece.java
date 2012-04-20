package kr.ac.jejuuniv.test;

import java.util.List;

public interface UserServiece {
	public abstract List<User> findAll();

	public abstract List<User> findById(String userId);

	public abstract List<User> createUser(String id, String name, String password);

	public abstract List<User> deleteByID(String userId);

	public abstract List<User> modifyUserById(String userId, String modifyName, String modifyPassword);
}
