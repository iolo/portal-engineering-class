package kr.juntheater.service;

import java.util.List;

import kr.juntheater.model.User;

//서비스를 구현하기 위한 인터페이스임.
public interface UserService {
	//구현할 메소드임. 
	public List<User> getList();
	public void create(User user);
	public void remove(String id);
	public User readId(String id);
	public void modify(User user);
}
