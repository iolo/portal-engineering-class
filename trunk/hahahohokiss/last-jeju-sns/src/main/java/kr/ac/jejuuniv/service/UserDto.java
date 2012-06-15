package kr.ac.jejuuniv.service;

import kr.ac.jejuuniv.model.User;

public class UserDto {
	private User user;
	private boolean follow;
	
	public UserDto(User user, boolean Follow) {
		this.user = user;
		this.follow = Follow;
	}
	
	public UserDto() {
		
	}
	
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public boolean isFollow() {
		return follow;
	}
	public void setFollow(boolean isFollow) {
		this.follow = isFollow;
	}
}
