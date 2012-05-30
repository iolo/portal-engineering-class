package kr.ac.jejuuniv.service.user;

public class NotFollowingUserException extends RuntimeException {

	private static final long serialVersionUID = 2238004510687678221L;

	public NotFollowingUserException(String message) {
		super(message);
	}
}
