package kr.ac.jejuuniv.service.user;

public class FollowingUserNotFoundException extends RuntimeException {

	private static final long serialVersionUID = -3364765874651153490L;

	public FollowingUserNotFoundException(String message) {
		super(message);
	}
}
