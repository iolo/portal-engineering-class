package kr.ac.jejuuniv.Model;

public class Follow {
	private User user;
	private Boolean state;
	
	public Follow() {
	}
	
	public Follow(User user, boolean state) {
		this.user = user;
		this.state = state;
	}
	
	public User getUser() {
		return user;
	}
	public Boolean getState() {
		return state;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public void setState(Boolean state) {
		this.state = state;
	}
	
	
}
