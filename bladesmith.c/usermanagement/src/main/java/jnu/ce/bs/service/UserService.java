package jnu.ce.bs.service;

import java.util.List;

public interface UserService {
	public abstract List<User> findAll();

	public abstract List<User> get(String userId);

	public abstract List<User> add(String id, String name, String password);

	public abstract List<User> delete(String userId);

	public abstract List<User> modify(String userId, String modifyName, String modifyPassword);
}
