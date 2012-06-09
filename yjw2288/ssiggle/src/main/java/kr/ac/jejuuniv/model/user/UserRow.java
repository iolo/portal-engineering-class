package kr.ac.jejuuniv.model.user;

public class UserRow {
	private User user;
	private boolean following;

	public UserRow() {
	}

	public UserRow(User user, boolean following) {
		this.user = user;
		this.following = following;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public boolean isFollowing() {
		return following;
	}

	public void setFollowing(boolean following) {
		this.following = following;
	}
}