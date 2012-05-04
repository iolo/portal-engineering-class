package kr.ac.jejuuniv;

import java.util.List;

public interface UserRepository {

	List<User> findAll();
	// <<1>> insert 메소드와 delete 메소드를 추가
	public void insert(String id, String name, String password);
	public void delete(String id);
	
	// <<9>> read 메소드 추가
	public User read(String id);
	
	// <<14>> modify 메소드 추가
	public void modify(User user);
	
	
}
