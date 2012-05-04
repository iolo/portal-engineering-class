package kr.ac.jejuuniv;

import java.util.List;

public interface UserService {
	public List<User> list();
	// <<4>> create, remove 메소드 추가
	public void create(User user);
	public void remove(String id);
	
	// <<7>> modify 구현을 위해 read 메소드 추가
	public User read(String id);
	
	// <<12>> modify 구현을 위해 modify 메소드 추가
	public void modify(User user);
}
