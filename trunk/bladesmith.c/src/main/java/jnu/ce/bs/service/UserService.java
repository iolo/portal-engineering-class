package jnu.ce.bs.service;

import java.util.List;

public interface UserService {
	public abstract List<User> findAll();
	
	public abstract Boolean duplicationIdCheck(String userId);

	public abstract User get(String userId);

	public abstract void add(String userId, String name, String password);

	public abstract void delete(String userId);

	public abstract void modify(String userId, String modifyName, String modifyPassword);

}
